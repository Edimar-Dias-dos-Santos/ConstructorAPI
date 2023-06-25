package com.constructor.constructorAPI.dtos;


import java.util.UUID;

public record CliFornecRecordDto(UUID idUsuario, double valor, int diasQueTrabalha,  String descricao) {
}