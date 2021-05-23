package com.projeto_transacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ProjetoTransacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTransacaoApplication.class, args);
	}

}
