package udesc.br.alsap.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NarrativaRequest {
    private String nome;
    private String idade;
    private String sexo;
    private String escolaridade;
    private String local;
    private String transcricao;
    private String resumo;
    private Long audio_id;
}
