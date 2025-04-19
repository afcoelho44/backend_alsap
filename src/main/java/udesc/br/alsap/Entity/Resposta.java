package udesc.br.alsap.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "questoes")
@ToString(exclude = "questoes")
@Entity

public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "audio_id")
    private Audio audio;

    @ManyToMany(mappedBy = "respostas")
    @JsonIgnore
    private Set<Questao> questoes = new HashSet<>();
}
