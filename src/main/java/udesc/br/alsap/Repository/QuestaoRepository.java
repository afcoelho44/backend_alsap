package udesc.br.alsap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.br.alsap.Entity.Questao;

import java.util.List;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    List<Questao> findByTipo(String tipo);
}
