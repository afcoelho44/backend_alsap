package udesc.br.alsap.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AudioRequest {
    private String transcricao;
    private String audio_url;

}
