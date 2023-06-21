package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record RecuperaLoginRecordDto(@NotBlank UUID idUsuario, @NotBlank String cpf, @NotBlank String dataNascimento, @NotBlank String ultimoNome) {


}




