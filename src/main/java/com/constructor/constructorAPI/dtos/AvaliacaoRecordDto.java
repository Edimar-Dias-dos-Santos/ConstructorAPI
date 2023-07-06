package com.constructor.constructorAPI.dtos;
import java.util.UUID;

public record AvaliacaoRecordDto(UUID id, UUID idUsuario, String descricao, int nota) {
}