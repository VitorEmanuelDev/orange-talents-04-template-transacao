package com.projeto_transacao.transacao;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;

import com.projeto_transacao.cartao.CartaoRequest;
import com.projeto_transacao.feign.CartaoTransacao;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    private CartaoTransacao cartaoTransacao;
    
    @Autowired
    private TransacaoRepository transacaoRepository;

    public TransacaoController(CartaoTransacao cartaoTransacao) {
        this.cartaoTransacao = cartaoTransacao;
    }

    @PostMapping
    public ResponseEntity<?> enviar(@RequestBody @Valid CartaoRequest request){
    try{
        cartaoTransacao.iniciarTransacao(request);
        return ResponseEntity.ok("Transação iniciada");
    }catch (FeignException.FeignServerException | FeignException.FeignClientException e){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> parar(@PathVariable("id") String id){
        try{
            cartaoTransacao.pararTransacao(id);
            return ResponseEntity.ok("Transação Finalizada");
        }catch (FeignException.FeignServerException | FeignException.FeignClientException e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/{numeroCartao}")
    public ResponseEntity<?> buscarUltimos10Registros(@PathVariable("numeroCartao") String numeroCartao){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("efetivadaEm").descending());
        Page<Transacao> list = transacaoRepository.findByCartaoId(numeroCartao,pageable);
        List<TransacaoResponse> transacoes = list.stream().map(transacao -> new TransacaoResponse(transacao)).collect(Collectors.toList());
        if(transacoes.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok(transacoes);
    }

}