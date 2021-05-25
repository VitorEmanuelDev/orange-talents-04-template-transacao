package com.projeto_transacao.cartao;



public class CartaoResponse {

    private Long id;

    private String email;

    @Deprecated
    public CartaoResponse() {
    }

    public CartaoResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao ToModel() {
        return new Cartao(id, email);
    }
}