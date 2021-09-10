package transacao.transacao;

import transacao.transacao.dtos.CartaoDTORequest;
import transacao.transacao.dtos.EstabelecimentoDTORequest;
import transacao.transacao.dtos.TransacaoDTORequest;
import transacao.transacao.entities.Cartao;
import transacao.transacao.entities.Estabelecimento;
import transacao.transacao.entities.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoDTORequest estabelecimento;
    private CartaoDTORequest cartao;
    private LocalDateTime efetivadaEm;

    public EventoDeTransacao(TransacaoDTORequest transacaoDTORequest) {

        this.valor = transacaoDTORequest.getValor();
        this.estabelecimento = transacaoDTORequest.getEstabelecimentoDTORequest();
        this.cartao = transacaoDTORequest.getCartaoDTORequest();
        this.efetivadaEm = transacaoDTORequest.getEfetivadaEm();

    }

    public EventoDeTransacao() {
    }

    public Transacao converter() {
        Estabelecimento estabelecimento = this.estabelecimento.converter();
        Cartao cartao = this.cartao.converter();
        return new Transacao(this.id, this.valor, estabelecimento, cartao, this.efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDTORequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDTORequest getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}