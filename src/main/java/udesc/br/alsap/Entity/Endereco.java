package udesc.br.alsap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Cidade;

    private String cep;

    private Double latitude;

    private Double longitude;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endereco")
    private List<Resposta> respostas;

}
