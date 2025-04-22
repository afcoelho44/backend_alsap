package udesc.br.alsap.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AudioRequest {
    private String nome;
    private String transcricao;
    private String audio_url;
    private Long resposta_id;
    private Long narrativa_id;

}
