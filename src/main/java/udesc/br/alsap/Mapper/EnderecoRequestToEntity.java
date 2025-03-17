package udesc.br.alsap.Mapper;

import udesc.br.alsap.Entity.Endereco;
import udesc.br.alsap.Model.EnderecoRequest;

public class EnderecoRequestToEntity implements InternMapper<Endereco, EnderecoRequest>{
    @Override
    public Endereco map(EnderecoRequest request) {
        var record = new Endereco();
        record.setCep(request.getCep());
        record.setCidade(request.getCidade());
        record.setLatitude(request.getLatitude());
        record.setLongitude(request.getLongitude());

        return record;
    }

    @Override
    public Endereco mapUpdate(EnderecoRequest request, Endereco record) {
        record.setCep(request.getCep());
        record.setCidade(request.getCidade());
        record.setLatitude(request.getLatitude());
        record.setLongitude(request.getLongitude());
        return record;
    }
}
