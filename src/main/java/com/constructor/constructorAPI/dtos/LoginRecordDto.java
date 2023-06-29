package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginRecordDto(@NotBlank String username, @NotBlank String password) {
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}