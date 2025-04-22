package udesc.br.alsap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String transcricao;
    private String audio_url;

    @ManyToOne
    @JoinColumn(name = "resposta_id", nullable = true)
    private Resposta resposta;

    @ManyToOne
    @JoinColumn(name = "narrativa_id", nullable = true)
    private Narrativa narrativa;

}
