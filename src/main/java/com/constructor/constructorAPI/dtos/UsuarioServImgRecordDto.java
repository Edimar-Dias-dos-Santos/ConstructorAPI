package com.constructor.constructorAPI.dtos;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record UsuarioServImgRecordDto(UUID idCliFornec, MultipartFile imageFile) {
}