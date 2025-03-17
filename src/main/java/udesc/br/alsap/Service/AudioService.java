package udesc.br.alsap.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import udesc.br.alsap.Entity.Audio;
import udesc.br.alsap.Mapper.AudioResquestToEntity;
import udesc.br.alsap.Model.AudioRequest;
import udesc.br.alsap.Repository.AudioRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AudioService {

    private AudioRepository repository;

    public ResponseEntity<List<Audio>> getAllAudios() { return new ResponseEntity<>(repository.findAll(), HttpStatus.OK); }

    public ResponseEntity<Audio> getAudioById(Long id){
        var response = repository.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public ResponseEntity<Long> createAudio(AudioRequest request){
        var entity = new AudioResquestToEntity().map(request);
        var id = repository.save(entity).getId();

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    public ResponseEntity<Audio> updateAudio(Long id, AudioRequest request){
        var record = repository.findById(id).orElseThrow(RuntimeException::new);
        record = new AudioResquestToEntity().mapUpdate(request, record);

        repository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    public ResponseEntity<Void> deleteAudio(Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
