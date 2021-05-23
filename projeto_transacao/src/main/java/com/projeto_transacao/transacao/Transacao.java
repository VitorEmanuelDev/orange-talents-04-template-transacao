package com.projeto_transacao.transacao;

import org.hibernate.annotations.CreationTimestamp;

import com.projeto_transacao.cartao.Cartao;
import com.projeto_transacao.estabelecimento.Estabelecimento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    @Positive
    private BigDecimal valor;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Cartao cartao;

    @CreationTimestamp
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Cartao cartao, Estabelecimento estabelecimento, LocalDateTime efetivadaEm) {
    this.id = id;
    this.valor = valor;
    this.cartao = cartao;
    this.estabelecimento = estabelecimento;
    this.efetivadaEm = efetivadaEm;
    }
}