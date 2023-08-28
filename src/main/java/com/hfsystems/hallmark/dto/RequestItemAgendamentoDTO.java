package com.hfsystems.hallmark.dto;

import com.hfsystems.hallmark.entities.Agendamento;
import com.hfsystems.hallmark.entities.Servico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RequestItemAgendamentoDTO(Long id, @NotBlank Agendamento agendamento, @NotBlank Servico servico,
                                        @NotBlank String horaItem, @NotNull BigDecimal valorItem) {
}
