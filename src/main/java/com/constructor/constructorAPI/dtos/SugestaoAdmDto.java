package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

public record SugestaoAdmDto(@NotBlank String nome, @NotBlank String descricao) {
}