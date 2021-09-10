package transacao.transacao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import transacao.transacao.entities.Transacao;

public interface TransacaoRepository  extends PagingAndSortingRepository<Transacao, String> {

    @Query("SELECT t FROM Cartao c,Transacao t WHERE c.id = t.cartao.id and c.id = :numCartao")
    Page<Transacao> findByCartao(String numCartao, Pageable pageable);

}
