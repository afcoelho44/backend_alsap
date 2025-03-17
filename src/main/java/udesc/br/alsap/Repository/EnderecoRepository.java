package udesc.br.alsap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.br.alsap.Entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
