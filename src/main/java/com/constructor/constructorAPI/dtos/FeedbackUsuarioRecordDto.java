package com.constructor.constructorAPI.dtos;

import java.util.UUID;

public record FeedbackUsuarioRecordDto(UUID idUsuario, int notaDeAvaliacao, String nomeReclamante, String comentario) {
}