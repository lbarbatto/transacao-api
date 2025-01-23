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

    //Lista para armazenar as Transações.
    private final List<TransacaoRequestDTO> transacaoLista = new ArrayList<>();

    //Método para adicionar uma Transação a Lista de Transações.
    public void addTransacao(TransacaoRequestDTO dto) {
        if (dto.dataHora().isAfter(OffsetDateTime.now())){ //Confere se dataHora da transação é posterior a data atual.
            throw new UnprocessableEntity("A dataHora não pode ser posterior ao momento atual.");
        }
        if (dto.valor() < 0){ //Confere se valor é negativo.
            throw new UnprocessableEntity("O valor não pode ser menor do que 0(ZERO).");
        }

        //Adiciona uma Transação à Lista de Transações.
        transacaoLista.add(dto);
    }

    //Método para apagar todas as Transações da Lista de Transações.
    public void dellTransacoes(){

        //Apaga todas as transações da lista.
        transacaoLista.clear();
    }

    public List<TransacaoRequestDTO> getTransacaoLista(Integer intervaloBusca){
        OffsetDateTime dataHoraBusca = OffsetDateTime.now().minusSeconds(intervaloBusca);
        return transacaoLista.stream()
                .filter(transacao -> transacao.dataHora().isAfter(dataHoraBusca))
                .toList();
    }
}
