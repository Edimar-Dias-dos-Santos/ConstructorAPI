package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.UsuarioRecordDto;
import com.constructor.constructorAPI.models.Usuario;
import com.constructor.constructorAPI.repositories.RepUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    RepUsuario repUsuario;

    @PostMapping("/Usuario")
    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) // Permitir apenas a origem http://localhost:4200
    public ResponseEntity<Usuario> saveUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto){
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRecordDto, usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(repUsuario.save(usuario));

    }



}
