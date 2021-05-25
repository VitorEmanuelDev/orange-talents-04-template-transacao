package com.projeto_transacao.cartao;


import javax.validation.constraints.*;

public class CartaoRequest {

    @NotBlank
    @NotNull
    private Long id;

    @Email
    private String email;

    @Deprecated
    public CartaoRequest() {
    }

    public CartaoRequest(Long id, String email) {
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