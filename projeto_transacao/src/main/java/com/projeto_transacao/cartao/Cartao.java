package com.projeto_transacao.cartao;


import javax.persistence.Entity;
import javax.validation.constraints.Email;
import org.springframework.data.annotation.Id;

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
    
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
}