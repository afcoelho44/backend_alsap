package udesc.br.alsap.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import udesc.br.alsap.Entity.Questao;
import udesc.br.alsap.Mapper.QuestaoRequestToEntity;
import udesc.br.alsap.Model.QuestaoRequest;
import udesc.br.alsap.Repository.QuestaoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestaoService {

    private QuestaoRepository repository;

    public ResponseEntity<List<Questao>> getAllQuestoes(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Questao> getQuestaoById(Long id){
        var questao = repository.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<>(questao, HttpStatus.OK);
    }
    public ResponseEntity<Long> createQuestao(QuestaoRequest request){
        var entity = new QuestaoRequestToEntity().map(request);
        var id = repository.save(entity).getId();

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    public ResponseEntity<Questao> updateAudio(Long id, QuestaoRequest request){
        var record = repository.findById(id).orElseThrow(RuntimeException::new);
        record = new QuestaoRequestToEntity().mapUpdate(request, record);

        repository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    public ResponseEntity<Void> deleteAudio(Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
