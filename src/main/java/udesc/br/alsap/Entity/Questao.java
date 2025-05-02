package udesc.br.alsap.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "respostas")
@ToString(exclude = "respostas")
@Entity
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;

    private String tipo;

    @ManyToMany
    @JoinTable(
            name = "questao_resposta",
            joinColumns = @JoinColumn(name = "questao_id"),
            inverseJoinColumns = @JoinColumn(name = "resposta_id")
    )
    private Set<Resposta> respostas =new HashSet<>();

    public void adicionarResposta(Resposta resposta) {
        this.respostas.add(resposta);
        resposta.getQuestoes().add(this);
    }

    public void removerResposta(Resposta resposta) {
        this.respostas.remove(resposta);
        resposta.getQuestoes().remove(this);
    }

}
