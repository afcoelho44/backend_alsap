package udesc.br.alsap.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.br.alsap.Entity.Questao;
import udesc.br.alsap.Model.QuestaoRequest;
import udesc.br.alsap.Service.QuestaoService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("alsap/Questao")

public class QuestaoController {

    private QuestaoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Questao> getQuestaoById(@PathVariable Long id){
        return service.getQuestaoById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Questao>> getAllQuestoes(){
        return service.getAllQuestoes();
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createQuestao(@RequestBody QuestaoRequest request){
        return service.createQuestao(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Questao> updateQuestao(@PathVariable Long id, @RequestBody QuestaoRequest request){
        return service.updateAudio(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestao(@PathVariable Long id){
        return service.deleteAudio(id);
    }
}
