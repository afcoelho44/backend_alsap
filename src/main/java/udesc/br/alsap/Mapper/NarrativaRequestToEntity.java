package udesc.br.alsap.Mapper;

import udesc.br.alsap.Entity.Narrativa;
import udesc.br.alsap.Model.NarrativaRequest;

public class NarrativaRequestToEntity implements InternMapper<Narrativa, NarrativaRequest>
{
    @Override
    public Narrativa map(NarrativaRequest request) {
        var record = new Narrativa();
        record.setNome(record.getNome());
        record.setIdade(record.getIdade());
        record.setSexo(record.getSexo());
        record.setEscolaridade(record.getEscolaridade());
        record.setLocal(record.getLocal());
        return record;
    }

    @Override
    public Narrativa mapUpdate(NarrativaRequest request, Narrativa record) {
        record.setNome(record.getNome());
        record.setIdade(record.getIdade());
        record.setSexo(record.getSexo());
        record.setEscolaridade(record.getEscolaridade());
        record.setLocal(record.getLocal());
        return record;
    }
}
