package com.constructor.constructorAPI.security.token;


import com.constructor.constructorAPI.dtos.UsuarioTokenDto;
import com.constructor.constructorAPI.models.Login;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenStructure {
    private String sub;
    private UsuarioTokenDto.Resumo usuario; //conferir
    private String roles;
    private Long exp;
    private Long iat;
    private String iss;
}