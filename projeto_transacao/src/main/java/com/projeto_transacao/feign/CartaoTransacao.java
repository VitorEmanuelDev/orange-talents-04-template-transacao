package com.projeto_transacao.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto_transacao.cartao.CartaoRequest;


@FeignClient(name = "transacao", url = "${transacao.host}")
public interface CartaoTransacao {

    @PostMapping
     void iniciarTransacao(@RequestBody CartaoRequest transacao);

    @DeleteMapping("/{id}")
    void pararTransacao(@PathVariable("id") String id);
}