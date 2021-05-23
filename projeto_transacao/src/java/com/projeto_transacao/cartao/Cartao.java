package com.projeto_transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

    @Id
    private String id;

    @Email
    private String email;

    @Deprecated
    public Cartao() {
    }
    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }
}