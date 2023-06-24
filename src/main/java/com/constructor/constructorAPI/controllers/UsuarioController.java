package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.UsuarioRecordDto;
import com.constructor.constructorAPI.models.Usuario;
import com.constructor.constructorAPI.repositories.RepUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/Usuario")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UsuarioController {

    @Autowired
    RepUsuario repUsuario;

    @PostMapping
    public ResponseEntity<Usuario> saveUser(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        var user = new Usuario();
        BeanUtils.copyProperties(usuarioRecordDto, user);
        user.setIdUsuario(UUID.randomUUID()); // Gera um novo UUID para o usuário
        return ResponseEntity.status(HttpStatus.CREATED).body(repUsuario.save(user));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsers() {
        List<Usuario> users = repUsuario.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable UUID id) {
        Optional<Usuario> optionalUser = repUsuario.findById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable UUID id, @RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        Optional<Usuario> optionalUser = repUsuario.findById(id);
        if (optionalUser.isPresent()) {
            Usuario user = optionalUser.get();
            BeanUtils.copyProperties(usuarioRecordDto, user);
            return ResponseEntity.ok(repUsuario.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        Optional<Usuario> optionalUser = repUsuario.findById(id);
        if (optionalUser.isPresent()) {
            repUsuario.delete(optionalUser.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}