package com.hfsystems.hallmark.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record RequestServicoDTO (Long id, @NotBlank String descricao, BigDecimal valor, @NotBlank String horaServico){
}
