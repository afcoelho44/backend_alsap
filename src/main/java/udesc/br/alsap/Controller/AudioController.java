package udesc.br.alsap.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.br.alsap.Entity.Audio;
import udesc.br.alsap.Model.AudioRequest;
import udesc.br.alsap.Repository.AudioRepository;
import udesc.br.alsap.Service.AudioService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("alsap/Audio")
public class AudioController {

    private AudioService service;

    @GetMapping("/all")
    public ResponseEntity<List<Audio>> getAllAudio(){
        return service.getAllAudios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Audio> getAudioById(@PathVariable Long id) {
        return service.getAudioById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createAudio(@RequestBody AudioRequest audioRequest) {
        return service.createAudio(audioRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Audio> upateAudio(@PathVariable Long id,@RequestBody AudioRequest audioRequest) {
        return service.updateAudio(id, audioRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAudio(@PathVariable Long id) {
        return service.deleteAudio(id);
    }

}

