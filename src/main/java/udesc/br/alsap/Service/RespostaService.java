package udesc.br.alsap.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import udesc.br.alsap.Entity.Questao;
import udesc.br.alsap.Entity.Resposta;
import udesc.br.alsap.Model.RespostaRequest;
import udesc.br.alsap.Repository.AudioRepository;
import udesc.br.alsap.Repository.EnderecoRepository;
import udesc.br.alsap.Repository.QuestaoRepository;
import udesc.br.alsap.Repository.RespostaRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class RespostaService {

    private RespostaRepository respostaRepository;

    private QuestaoRepository questaoRepository;

    private AudioRepository audioRepository;

    private EnderecoRepository enderecoRepository;

    public ResponseEntity<List<Resposta>> getAllRespostas() {
        return new ResponseEntity<>(respostaRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Resposta> getRespostaById(Long id){
        var response = respostaRepository.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Long> createResposta(RespostaRequest request) {
        var entity = new Resposta();
        entity = respostaRequestToEntity(request, entity);
        var id = respostaRepository.save(entity).getId();
        try {
            var questao = questaoRepository.findById(request.getQuestao_id()).orElseThrow(RuntimeException::new);
            questao.getRespostas().add(entity);
            entity.getQuestoes().add(questao);
            questaoRepository.save(questao);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    public ResponseEntity<Resposta> updateResposta(Long id, RespostaRequest request) {
        var record = respostaRepository.findById(id).orElseThrow(RuntimeException::new);
        record = respostaRequestToEntity(request, record);
        respostaRepository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    private Resposta respostaRequestToEntity(RespostaRequest request, Resposta record) {
        var audio = audioRepository.findById(request.getAudio_id()).orElseThrow(RuntimeException::new);
        var endereco = enderecoRepository.findById(request.getEndereco_id()).orElseThrow(RuntimeException::new);
        record.setAudio(audio);
        record.setEndereco(endereco);
        return record;
    }

    public ResponseEntity<Void> deleteResposta(Long id) {
        var resposta = respostaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resposta não encontrada"));

        for (Questao questao : resposta.getQuestoes()) {
            questao.getRespostas().remove(resposta);
        }

        respostaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
