package transacao.transacao.dtos;

import org.springframework.data.domain.Page;
import transacao.transacao.entities.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDTOResponse {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoDTOResponse estabelecimento;
    private CartaoDTOResponse cartao;

    public TransacaoDTOResponse() {
    }

    public TransacaoDTOResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = transacao.getEstabelecimento().converter();
        this.cartao = transacao.getCartao().converter();
    }

    public static Page<TransacaoDTOResponse> converter(Page<Transacao> transacoes) {
        return transacoes.map(TransacaoDTOResponse::new);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoDTOResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDTOResponse getCartao() {
        return cartao;
    }
}

