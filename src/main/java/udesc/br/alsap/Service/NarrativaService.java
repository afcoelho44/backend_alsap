package udesc.br.alsap.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import udesc.br.alsap.Entity.Narrativa;
import udesc.br.alsap.Mapper.NarrativaRequestToEntity;
import udesc.br.alsap.Model.NarrativaRequest;
import udesc.br.alsap.Repository.AudioRepository;
import udesc.br.alsap.Repository.NarrativaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NarrativaService {

    private NarrativaRepository repositoryNarrativa;
    private AudioRepository audioRepository;

    public ResponseEntity<List<Narrativa>> getAllNarrativass() {
        return new ResponseEntity<>(repositoryNarrativa.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Narrativa> getNarrativaById(Long id) {
        var response = repositoryNarrativa.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public ResponseEntity<Long> createNarrativa(NarrativaRequest request) {
        var entity = new Narrativa();
        entity = new NarrativaRequestToEntity().map(request);
        String cidade = request.getLocal().split("-")[0].trim();
        long quantidade = repositoryNarrativa.countByCidade(cidade)+1;
        String titulo = String.format("Narrativa - %s - %02d", cidade.toUpperCase(), quantidade);
        entity.setTitulo(titulo);
        var audio = audioRepository.findById(request.getAudio_id()).orElseThrow(RuntimeException::new);
        entity.setAudio(audio);
        var id = repositoryNarrativa.save(entity).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
    public ResponseEntity<Narrativa> updateNarrativa(Long id, NarrativaRequest request) {
        var record = repositoryNarrativa.findById(id).orElseThrow(RuntimeException::new);
        record = new NarrativaRequestToEntity().mapUpdate(request, record);
        var audio = audioRepository.findById(request.getAudio_id()).orElseThrow(RuntimeException::new);
        record.setAudio(audio);
        repositoryNarrativa.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    public ResponseEntity<Void> deleteNarrativa(Long id) {
        repositoryNarrativa.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
