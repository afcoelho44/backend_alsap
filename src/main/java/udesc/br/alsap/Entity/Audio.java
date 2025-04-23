package udesc.br.alsap.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name = "resposta", nullable = true)
    @JsonBackReference(value = "respostaRef")
    private Resposta resposta;

    @ManyToOne
    @JoinColumn(name = "narrativa", nullable = true)
    @JsonBackReference(value = "narrativaRef")
    private Narrativa narrativa;

}
