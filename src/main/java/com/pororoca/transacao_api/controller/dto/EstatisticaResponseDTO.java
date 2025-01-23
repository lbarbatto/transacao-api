package com.pororoca.transacao_api.controller.dto;

public record EstatisticaResponseDTO(
        Long cont,
        Double sum,
        Double avg,
        Double min,
        Double max
) { }