package com.pororoca.transacao_api.model.services;

import com.pororoca.transacao_api.controller.dto.EstatisticaResponseDTO;
import com.pororoca.transacao_api.controller.dto.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticaService {

    public final TransacaoService transacaoService;

    public EstatisticaResponseDTO getEstatistica(Integer intervaloBusca) {
        List<TransacaoRequestDTO> transacaoLista = transacaoService.getTransacaoLista(intervaloBusca);
        DoubleSummaryStatistics estatistica = transacaoLista.stream()
                .mapToDouble(TransacaoRequestDTO::valor)
                .summaryStatistics();

        return new EstatisticaResponseDTO(estatistica.getCount(),
                estatistica.getSum(),
                estatistica.getAverage(),
                estatistica.getMin(),
                estatistica.getMax());
    }
}
