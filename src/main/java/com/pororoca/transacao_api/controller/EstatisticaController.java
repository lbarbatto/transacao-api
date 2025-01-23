package com.pororoca.transacao_api.controller;


import com.pororoca.transacao_api.controller.dto.EstatisticaResponseDTO;
import com.pororoca.transacao_api.model.services.EstatisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<EstatisticaResponseDTO> getEstatistica(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca){

        return ResponseEntity.ok(estatisticaService.getEstatistica(intervaloBusca));
    }
}
