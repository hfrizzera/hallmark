package com.hfsystems.hallmark.dto;

import com.hfsystems.hallmark.entities.Pessoa;
import com.hfsystems.hallmark.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record RequestAgendamentoDTO(Long id, @NotNull Pessoa pessoa, @NotNull Usuario usuario, @NotNull Date dataAgendamento,
                                    @NotBlank String horaInicio, @NotBlank String horaFinal, @NotNull BigDecimal valorTotalServico) {
}
