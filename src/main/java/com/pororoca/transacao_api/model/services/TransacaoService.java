package com.pororoca.transacao_api.model.services;

import com.pororoca.transacao_api.controller.dto.TransacaoRequestDTO;
import com.pororoca.transacao_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final List<TransacaoRequestDTO> transacaoLista = new ArrayList<>();

    public void addTransacao(TransacaoRequestDTO dto) {
        if (dto.dataHora().isAfter(OffsetDateTime.now())){
            throw new UnprocessableEntity("A dataHora não pode ser posterior ao momento atual.");
        }
        if (dto.valor() < 0){
            throw new UnprocessableEntity("O valor não pode ser menor do que 0(ZERO).");
        }
        if (dto.valor().toString().isEmpty() || dto.valor().toString().isBlank()){
            throw new UnprocessableEntity("O valor não pode estar vazio.");
        }
        if ((dto.dataHora().toString().isEmpty() || dto.dataHora().toString().isBlank())){
            throw new UnprocessableEntity("A dataHora não pode estar vazia.");
        }

        transacaoLista.add(dto);
    }

    public void dellTransacoes(){
        transacaoLista.clear();
    }
}
