package udesc.br.alsap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.br.alsap.Entity.Audio;

public interface AudioRepository extends JpaRepository<Audio, Long> {
}
