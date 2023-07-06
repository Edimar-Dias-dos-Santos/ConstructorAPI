package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDto(@NotBlank String nome, String profissao, String urlPerfil, @NotBlank String email, @NotBlank String telefone, boolean  permissao) {
}
