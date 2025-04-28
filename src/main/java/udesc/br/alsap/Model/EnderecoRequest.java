package udesc.br.alsap.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    private String nome;

    private String cep;

    private Double latitude;

    private Double longitude;
}
