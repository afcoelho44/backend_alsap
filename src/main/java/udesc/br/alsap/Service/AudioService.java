package udesc.br.alsap.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import udesc.br.alsap.Entity.Audio;
import udesc.br.alsap.Mapper.AudioResquestToEntity;
import udesc.br.alsap.Model.AudioRequest;
import udesc.br.alsap.Repository.AudioRepository;
import udesc.br.alsap.Repository.NarrativaRepository;
import udesc.br.alsap.Repository.RespostaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AudioService {

    private AudioRepository audioRepository;
    private RespostaRepository respostaRepository;
    private NarrativaRepository narrativaRepository;

    public ResponseEntity<List<Audio>> getAllAudios() { return new ResponseEntity<>(audioRepository.findAll(), HttpStatus.OK); }

    public ResponseEntity<Audio> getAudioById(Long id){
        var response = audioRepository.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public ResponseEntity<Long> createAudio(AudioRequest request){
        var entity = new AudioResquestToEntity().map(request);
        if (request.getResposta_id() != null) {
            var resposta = respostaRepository.findById(request.getResposta_id()).orElseThrow(RuntimeException::new);
            entity.setResposta(resposta);
        }

        if (request.getNarrativa_id() != null) {
            var narrativa = narrativaRepository.findById(request.getNarrativa_id()).orElseThrow(RuntimeException::new);
            entity.setNarrativa(narrativa);
        }
        var id = audioRepository.save(entity).getId();

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    public ResponseEntity<Audio> updateAudio(Long id, AudioRequest request){
        var record = audioRepository.findById(id).orElseThrow(RuntimeException::new);
        record = new AudioResquestToEntity().mapUpdate(request, record);
        if (request.getResposta_id() != null) {
            var resposta = respostaRepository.findById(request.getResposta_id()).orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
            record.setResposta(resposta);
        }else if (request.getNarrativa_id()!= null) {
            var narrativa = narrativaRepository.findById(request.getNarrativa_id()).orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
            record.setNarrativa(narrativa);
        }

        audioRepository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    public ResponseEntity<Void> deleteAudio(Long id){
        var audio = audioRepository.findById(id).orElseThrow(() -> new RuntimeException("Áudio não encontrado"));

        var resposta = audio.getResposta();
        resposta.getAudios().remove(audio);

        respostaRepository.save(resposta);
        audioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
