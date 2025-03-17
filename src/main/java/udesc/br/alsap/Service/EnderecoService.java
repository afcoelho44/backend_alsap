package udesc.br.alsap.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import udesc.br.alsap.Entity.Endereco;
import udesc.br.alsap.Mapper.EnderecoRequestToEntity;
import udesc.br.alsap.Model.EnderecoRequest;
import udesc.br.alsap.Repository.EnderecoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository repository;

    public ResponseEntity<List<Endereco>> getAllEndereco() { return new ResponseEntity<>(repository.findAll(), HttpStatus.OK); }

    public ResponseEntity<Endereco> getEnderecoById(Long id){
        var response = repository.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    public ResponseEntity<Long> createEndereco(EnderecoRequest request){
        var entity = new EnderecoRequestToEntity().map(request);
        var id = repository.save(entity).getId();

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    public ResponseEntity<Endereco> updateEndereco(Long id, EnderecoRequest request){
        var record = repository.findById(id).orElseThrow(RuntimeException::new);
        record = new EnderecoRequestToEntity().mapUpdate(request, record);

        repository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    public ResponseEntity<Void> deleteEndereco(Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
