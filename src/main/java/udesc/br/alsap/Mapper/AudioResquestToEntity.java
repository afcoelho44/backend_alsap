package udesc.br.alsap.Mapper;

import udesc.br.alsap.Entity.Audio;
import udesc.br.alsap.Model.AudioRequest;

public class AudioResquestToEntity implements InternMapper<Audio, AudioRequest>{
    @Override
    public Audio map(AudioRequest request) {
        var record = new Audio();
        record.setNome(request.getNome());
        record.setAudio_url(request.getAudio_url());
        record.setTranscricao(request.getTranscricao());
        record.setTipo(request.getTipo());
        return record;
    }

    @Override
    public Audio mapUpdate(AudioRequest request, Audio record) {
        record.setNome(request.getNome());
        record.setAudio_url(request.getAudio_url());
        record.setTranscricao(request.getTranscricao());
        record.setTipo(request.getTipo());
        return record;
    }
}
