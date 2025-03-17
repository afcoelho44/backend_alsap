package udesc.br.alsap.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.br.alsap.Entity.Endereco;
import udesc.br.alsap.Model.EnderecoRequest;
import udesc.br.alsap.Service.EnderecoService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/Endereco")
public class EnderecoController {

    private EnderecoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
        return service.getEnderecoById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Endereco>> getAllEndereco() {
        return service.getAllEndereco();
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createEndereco(@RequestBody EnderecoRequest request){
        return service.createEndereco(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody EnderecoRequest request){
        return service.updateEndereco(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id){
        return service.deleteEndereco(id);
    }

}
