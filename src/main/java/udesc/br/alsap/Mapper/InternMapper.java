package udesc.br.alsap.Mapper;

public interface InternMapper <T, R>{
    T map(R request);
    T mapUpdate(R request, T record);
}
