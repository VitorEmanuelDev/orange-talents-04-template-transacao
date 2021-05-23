package com.projeto_transacao.cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartaoRequest {

    @NotBlank
    @NotNull
    private String id;

    @Email
    private String email;

    @Deprecated
    public CartaoRequest() {
    }

    public CartaoRequest(String id, String email) {
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
