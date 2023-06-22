package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CliFornecRecordDto(@NotBlank UUID idUsuario, double valor, int diasQueTrabalha, @NotBlank String descricao) {
}