package udesc.br.alsap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.br.alsap.Entity.Narrativa;

public interface NarrativaRepository  extends JpaRepository<Narrativa, Long> {
}
