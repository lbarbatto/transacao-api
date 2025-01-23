package com.pororoca.transacao_api.controller.dto;


import java.time.OffsetDateTime;

//DTO modelo para entrada dos dados.
public record TransacaoRequestDTO(Double valor, OffsetDateTime dataHora) {
}
