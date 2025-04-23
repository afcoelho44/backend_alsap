package udesc.br.alsap.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"questoes", "audios"})
@ToString(exclude = {"questoes", "audios"})
@Entity

public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "resposta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "respostaRef")
    private Set<Audio> audios = new HashSet<>();

    @ManyToMany(mappedBy = "respostas")
    @JsonIgnore
    private Set<Questao> questoes = new HashSet<>();

    public void adicionarQuestao(Questao questao) {
        this.questoes.add(questao);
        questao.getRespostas().add(this);
    }

    public void removerQuestao(Questao questao) {
        this.questoes.remove(questao);
        questao.getRespostas().remove(this);
    }

}
