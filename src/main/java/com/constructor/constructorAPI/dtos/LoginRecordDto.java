package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginRecordDto(String codigoLogado, @NotBlank String username, @NotBlank String password) {
    // Construtor e getters automáticos gerados pelo record
}