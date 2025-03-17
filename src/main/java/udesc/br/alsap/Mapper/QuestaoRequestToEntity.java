package udesc.br.alsap.Mapper;

import org.apache.catalina.mapper.Mapper;
import udesc.br.alsap.Entity.Questao;
import udesc.br.alsap.Model.QuestaoRequest;

public class QuestaoRequestToEntity implements InternMapper<Questao, QuestaoRequest> {
    @Override
    public Questao map(QuestaoRequest request) {
        var record = new Questao();
        record.setDescricao(request.getDescricao());
        return record;
    }

    @Override
    public Questao mapUpdate(QuestaoRequest request, Questao record) {
        record.setDescricao(request.getDescricao());
        return record;
    }
}
