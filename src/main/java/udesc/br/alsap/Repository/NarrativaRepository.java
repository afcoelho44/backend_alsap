package udesc.br.alsap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import udesc.br.alsap.Entity.Narrativa;

public interface NarrativaRepository  extends JpaRepository<Narrativa, Long> {
    @Query("SELECT COUNT(n) FROM Narrativa n WHERE LOWER(n.local) LIKE LOWER(:cidade || '%')")
    long countByCidade(String cidade);

}
