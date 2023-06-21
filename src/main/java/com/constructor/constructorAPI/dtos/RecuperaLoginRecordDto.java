package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record RecuperaLoginRecordDto(@NotBlank UUID idUsuario, @NotBlank String cpf, @NotBlank LocalDate dataNascimento, @NotBlank String ultimoNome) {


}




