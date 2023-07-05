package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record LoginRecordDto(@NotBlank String username,UUID getCodigoLogado, UUID idUsuario, @NotBlank String password) {
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}