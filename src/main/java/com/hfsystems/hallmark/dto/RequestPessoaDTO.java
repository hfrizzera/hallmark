package com.hfsystems.hallmark.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestPessoaDTO(Long id, @NotBlank String nome, @NotBlank String telefone) {
}
