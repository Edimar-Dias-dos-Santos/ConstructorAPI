package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.LoginRecordDto;
import com.constructor.constructorAPI.dtos.models.Login;
import com.constructor.constructorAPI.repositories.RepLogin;
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
@RequestMapping("api/Login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private RepLogin repLogin;

    @PostMapping("/authenticate")
    public ResponseEntity<Login> authenticateUser(@RequestBody @Valid LoginRecordDto loginRecordDto) {
        String username = loginRecordDto.getUsername();
        String password = loginRecordDto.getPassword();

        Optional<Login> optionalLogin = repLogin.findByUsernameAndPassword(username, password);
        if (optionalLogin.isPresent()) {
            Login login = optionalLogin.get();
            login.getUsuario(); // Certifique-se de que o relacionamento com o objeto "Usuario" seja carregado

            return ResponseEntity.ok(login);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @GetMapping("/idUsuario")
    public ResponseEntity<UUID> getIdUsuarioByUsernameAndPassword(@RequestParam String username, @RequestParam String password) {
        Optional<Login> optionalLogin = repLogin.findByUsernameAndPassword(username, password);
        if (optionalLogin.isPresent()) {
            Login login = optionalLogin.get();
            UUID idUsuario = login.getUsuario().getIdUsuario();
            return ResponseEntity.ok(idUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Login> saveLogin(@RequestBody @Valid Login login) {
        login.setIdLogin(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.CREATED).body(repLogin.save(login));
    }

    @GetMapping
    public ResponseEntity<List<Login>> getLogins() {
        List<Login> logins = repLogin.findAll();
        return ResponseEntity.ok(logins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable UUID id) {
        Optional<Login> optionalLogin = repLogin.findById(id);
        if (optionalLogin.isPresent()) {
            return ResponseEntity.ok(optionalLogin.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable UUID id, @RequestBody @Valid Login updatedLogin) {
        Optional<Login> optionalLogin = repLogin.findById(id);
        if (optionalLogin.isPresent()) {
            Login login = optionalLogin.get();
            BeanUtils.copyProperties(updatedLogin, login, "idLogin");
            return ResponseEntity.ok(repLogin.save(login));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable UUID id) {
        Optional<Login> optionalLogin = repLogin.findById(id);
        if (optionalLogin.isPresent()) {
            repLogin.delete(optionalLogin.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}