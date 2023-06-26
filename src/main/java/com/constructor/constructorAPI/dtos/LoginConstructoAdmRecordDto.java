package com.constructor.constructorAPI.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginConstructoAdmRecordDto(@NotBlank String username, @NotBlank String password) {
}