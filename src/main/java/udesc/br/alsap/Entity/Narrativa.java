package udesc.br.alsap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Narrativa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String idade;
    private String sexo;
    private String escolaridade;
    private String local;

    @OneToOne
    @JoinColumn(name = "audio_id")
    private Audio audio;
}
