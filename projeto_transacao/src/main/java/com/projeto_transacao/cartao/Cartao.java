package com.projeto_transacao.cartao;


import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @Deprecated
    public Cartao() {
    }
    
    public Cartao(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}