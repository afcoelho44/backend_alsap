package udesc.br.alsap.Mapper;

import udesc.br.alsap.Entity.Narrativa;
import udesc.br.alsap.Model.NarrativaRequest;

public class NarrativaRequestToEntity implements InternMapper<Narrativa, NarrativaRequest>
{
    @Override
    public Narrativa map(NarrativaRequest request) {
        var record = new Narrativa();
        record.setNome(request.getNome());
        record.setIdade(request.getIdade());
        record.setSexo(request.getSexo());
        record.setEscolaridade(request.getEscolaridade());
        record.setLocal(request.getLocal());
        record.setTranscricao(request.getTranscricao());
        return record;
    }

    @Override
    public Narrativa mapUpdate(NarrativaRequest request, Narrativa record) {
        record.setNome(request.getNome());
        record.setIdade(request.getIdade());
        record.setSexo(request.getSexo());
        record.setEscolaridade(request.getEscolaridade());
        record.setLocal(request.getLocal());
        record.setTranscricao(request.getTranscricao());
        return record;
    }
}
