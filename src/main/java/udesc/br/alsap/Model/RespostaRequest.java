package udesc.br.alsap.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespostaRequest {
    private Long endereco_id;
    private Long audio_id;
    private Long questao_id;
}
