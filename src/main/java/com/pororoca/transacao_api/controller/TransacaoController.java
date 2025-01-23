package com.pororoca.transacao_api.controller;

import com.pororoca.transacao_api.controller.dto.TransacaoRequestDTO;
import com.pororoca.transacao_api.model.services.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao") //endpoint para manipular as Transações.
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> addTransacao(@RequestBody TransacaoRequestDTO dto){
        transacaoService.addTransacao(dto); //Chamada do método para adicionar uma transação à Lista de Transações.
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> dellTransacoes(){
        transacaoService.dellTransacoes(); //Chamada do método pra apagar todas as transações da Lista de Transações.
        return ResponseEntity.ok().build();
    }
}
