package com.pororoca.transacao_api.controller;

import com.pororoca.transacao_api.controller.dto.TransacaoRequestDTO;
import com.pororoca.transacao_api.model.services.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> addTransacao(@RequestBody TransacaoRequestDTO dto){
        transacaoService.addTransacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> dellTransacoes(){
        transacaoService.dellTransacoes();
        return ResponseEntity.ok().build();
    }
}
