package udesc.br.alsap.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.br.alsap.Entity.Resposta;
import udesc.br.alsap.Model.RespostaRequest;
import udesc.br.alsap.Service.RespostaService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("alsap/Respostas")
public class RespostaController {

    private RespostaService service;

    @GetMapping("/all")
    public ResponseEntity<List<Resposta>> getAllRespostas(){
        return service.getAllRespostas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resposta> getRespostaById(@PathVariable Long id){
        return service.getRespostaById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createResposta(@RequestBody RespostaRequest request){
        return service.createResposta(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Resposta> updateResposta(@PathVariable Long id, @RequestBody RespostaRequest request){
        return service.updateResposta(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResposta(@PathVariable Long id){
        return service.deleteResposta(id);
    }


}
