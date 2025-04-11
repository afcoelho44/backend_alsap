package udesc.br.alsap.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udesc.br.alsap.Entity.Narrativa;
import udesc.br.alsap.Model.NarrativaRequest;
import udesc.br.alsap.Service.NarrativaService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("alsap/Narrativa")
public class NarrativaController {

    private NarrativaService service;

    @GetMapping("/all")
    public ResponseEntity<List<Narrativa>> getNarrativa(){
        return service.getAllNarrativass();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Narrativa> getNarrativaById(@PathVariable Long id){
        return service.getNarrativaById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<Long> createNarrativa(@RequestBody NarrativaRequest request){
        return service.createNarrativa(request);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Narrativa> updateNarrativa(@PathVariable Long id, @RequestBody NarrativaRequest request){
        return service.updateNarrativa(id, request);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNarrativa(@PathVariable Long id){
       return service.deleteNarrativa(id);
    }
}
