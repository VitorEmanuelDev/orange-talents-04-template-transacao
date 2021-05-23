package com.projeto_transacao.transacao;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.projeto_transacao.cartao.CartaoResponse;
import com.projeto_transacao.estabelecimento.EstabelecimentoResponse;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponse estabelecimento;


    @Deprecated
    public TransacaoResponse() {
    }



    public String getId() {
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