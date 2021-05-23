package com.projeto_transacao.transacao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, String> {

    Page<Transacao> findByCartaoId(String numeroCartao, Pageable pageable);
    
}