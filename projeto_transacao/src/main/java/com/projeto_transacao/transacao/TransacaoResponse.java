package com.projeto_transacao.transacao;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.projeto_transacao.cartao.CartaoResponse;
import com.projeto_transacao.estabelecimento.EstabelecimentoResponse;

public class TransacaoResponse {

    private Long id;
    private BigDecimal valor;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponse estabelecimento;


    @Deprecated
    public TransacaoResponse() {
    }
    
    public TransacaoResponse(Transacao transacao) {
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.cartao = new CartaoResponse(transacao.getCartao().getId(), transacao.getCartao().getEmail());
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento().getNome(), transacao.getEstabelecimento().getCidade(), transacao.getEstabelecimento().getEndereco());
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public Transacao toModel(){
        return new Transacao(id, valor, cartao.ToModel(), estabelecimento.toModel(), efetivadaEm);
    }
}