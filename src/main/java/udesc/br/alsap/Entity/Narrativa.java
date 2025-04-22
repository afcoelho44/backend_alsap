package udesc.br.alsap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    @Column(columnDefinition = "TEXT")
    private String transcricao;

    private String titulo;

    @OneToMany(mappedBy = "narrativa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Audio> audios = new HashSet<>();
}
