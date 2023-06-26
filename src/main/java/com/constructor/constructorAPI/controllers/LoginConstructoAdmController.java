package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.LoginConstructoAdmRecordDto;
import com.constructor.constructorAPI.models.LoginConstructoAdm;
import com.constructor.constructorAPI.repositories.RepLoginConstructoAdm;
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
@RequestMapping("api/LoginConstructoAdm")
@CrossOrigin("*")
public class LoginConstructoAdmController {

    @Autowired
    private RepLoginConstructoAdm repLoginConstructoAdm;

    @PostMapping("/authenticate")
    public ResponseEntity<LoginConstructoAdm> authenticateUser(@RequestBody @Valid LoginConstructoAdmRecordDto loginRecordDto) {
        String username = loginRecordDto.username();
        String password = loginRecordDto.password();

        Optional<LoginConstructoAdm> optionalLogin = repLoginConstructoAdm.findByUsernameAndPassword(username, password);
        if (optionalLogin.isPresent()) {
            return ResponseEntity.ok(optionalLogin.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<LoginConstructoAdm> saveLogin(@RequestBody @Valid LoginConstructoAdm login) {
        login.setIdLogin(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.CREATED).body(repLoginConstructoAdm.save(login));
    }

    @GetMapping
    public ResponseEntity<List<LoginConstructoAdm>> getAllLogins() {
        List<LoginConstructoAdm> logins = repLoginConstructoAdm.findAll();
        return ResponseEntity.ok(logins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginConstructoAdm> getLoginById(@PathVariable UUID id) {
        Optional<LoginConstructoAdm> optionalLogin = repLoginConstructoAdm.findById(id);
        return optionalLogin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginConstructoAdm> updateLogin(@PathVariable UUID id, @RequestBody @Valid LoginConstructoAdm updatedLogin) {
        Optional<LoginConstructoAdm> optionalLogin = repLoginConstructoAdm.findById(id);
        if (optionalLogin.isPresent()) {
            LoginConstructoAdm login = optionalLogin.get();
            BeanUtils.copyProperties(updatedLogin, login, "idLogin");
            return ResponseEntity.ok(repLoginConstructoAdm.save(login));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable UUID id) {
        Optional<LoginConstructoAdm> optionalLogin = repLoginConstructoAdm.findById(id);
        if (optionalLogin.isPresent()) {
            repLoginConstructoAdm.delete(optionalLogin.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}