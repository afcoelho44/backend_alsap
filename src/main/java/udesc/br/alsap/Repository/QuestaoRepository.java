package udesc.br.alsap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.br.alsap.Entity.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
}
