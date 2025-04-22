package udesc.br.alsap.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import udesc.br.alsap.Entity.Questao;
import udesc.br.alsap.Entity.Resposta;
import udesc.br.alsap.Model.RespostaRequest;
import udesc.br.alsap.Repository.AudioRepository;
import udesc.br.alsap.Repository.EnderecoRepository;
import udesc.br.alsap.Repository.QuestaoRepository;
import udesc.br.alsap.Repository.RespostaRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class RespostaService {

    private RespostaRepository respostaRepository;

    private QuestaoRepository questaoRepository;

    private EnderecoRepository enderecoRepository;

    public ResponseEntity<List<Resposta>> getAllRespostas() {
        return new ResponseEntity<>(respostaRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Resposta> getRespostaById(Long id){
        var response = respostaRepository.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Long> createResposta(RespostaRequest request) {
        var entity = new Resposta();
        var endereco = enderecoRepository.findById(request.getEndereco_id()).orElseThrow(RuntimeException::new);
        var questao = questaoRepository.findById(request.getQuestao_id()).orElseThrow(RuntimeException::new);
        entity.setEndereco(endereco);
        var id = respostaRepository.save(entity).getId();
        try {
            vincularRespostaAQuestao(questao.getId(), id);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    public ResponseEntity<Resposta> updateResposta(Long id, RespostaRequest request) {
        var record = respostaRepository.findById(id).orElseThrow(RuntimeException::new);
        var endereco = enderecoRepository.findById(request.getEndereco_id()).orElseThrow(RuntimeException::new);
        var questao_nova = questaoRepository.findById(request.getQuestao_id()).orElseThrow(RuntimeException::new);
        for (Questao questao : record.getQuestoes()) {
            desvincularRespostaDeQuestao(questao.getId(), record.getId());
        }
        vincularRespostaAQuestao(questao_nova.getId(), id);
        record.setEndereco(endereco);
        respostaRepository.save(record);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteResposta(Long id) {
        var resposta = respostaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resposta não encontrada"));

        for (Questao questao : resposta.getQuestoes()) {
            desvincularRespostaDeQuestao(questao.getId(), resposta.getId());
        }

        respostaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public void vincularRespostaAQuestao(Long questaoId, Long respostaId) {
        var questao = questaoRepository.findById(questaoId)
                .orElseThrow(() -> new RuntimeException("Questão não encontrada"));

        var resposta = respostaRepository.findById(respostaId)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));

        questao.adicionarResposta(resposta);
        questaoRepository.save(questao);
    }

    public void desvincularRespostaDeQuestao(Long questaoId, Long respostaId) {
        var questao = questaoRepository.findById(questaoId)
                .orElseThrow(() -> new RuntimeException("Questão não encontrada"));

        var resposta = respostaRepository.findById(respostaId)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));

        questao.removerResposta(resposta);
        questaoRepository.save(questao);
    }



}
