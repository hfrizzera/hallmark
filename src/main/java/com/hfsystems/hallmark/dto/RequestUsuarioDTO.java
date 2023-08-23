package com.hfsystems.hallmark.dto;

import com.hfsystems.hallmark.entities.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUsuarioDTO(Long id, @NotBlank String login, @NotBlank String senha, String foto, @NotNull Pessoa pessoa) {
}
