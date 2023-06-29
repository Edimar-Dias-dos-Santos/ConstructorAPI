package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginRecordDto(String codigoLogado, @NotBlank String username, @NotBlank String password) {

    public String getCodigoLogado() {
        return codigoLogado;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}