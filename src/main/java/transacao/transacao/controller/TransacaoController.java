package transacao.transacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import transacao.transacao.dtos.TransacaoDTOResponse;
import transacao.transacao.entities.Cartao;
import transacao.transacao.entities.Transacao;
import transacao.transacao.repositories.CartaoRepository;
import transacao.transacao.repositories.TransacaoRepository;
import transacao.transacao.validators.ErroAPI;

import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    @GetMapping("{id}")
    @Cacheable(value = "listaDeTransacaoes")
    public ResponseEntity<?> lista(@PathVariable("id") String idCartao,
                                   @PageableDefault(direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {

        Optional<Cartao> cartaoOptional = cartaoRepository.findById(idCartao);
        if(!cartaoOptional.isPresent()){
            return ResponseEntity.status(404).body(new ErroAPI("Cartão","O cartão não foi encontrado na base de dados."));
        }
        Page<Transacao> transacoes = transacaoRepository.findByCartao(idCartao,paginacao);
        return ResponseEntity.status(200).body(TransacaoDTOResponse.converter(transacoes).getContent());

    }

}
