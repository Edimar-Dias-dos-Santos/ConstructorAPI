package com.constructor.constructorAPI.dtos;

import com.constructor.constructorAPI.models.Usuario;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

public interface UsuarioTokenDto {

    @Data
    @Builder
    class Resumo{

        private UUID idUsuario;
        @NotEmpty(message = "O nome não pode ser nulo")
        private String nome;

        public static UsuarioTokenDto.Resumo from(Usuario usuario){
            return Resumo.builder()
                    .nome(usuario.getNome())
                    .idUsuario(usuario.getIdUsuario())
                    .build();
        }
    }
}
