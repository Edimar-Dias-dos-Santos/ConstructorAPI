package com.constructor.constructorAPI.controllers;
import com.constructor.constructorAPI.dtos.RecuperaLoginRecordDto;
import com.constructor.constructorAPI.models.RecuperaLogin;
import com.constructor.constructorAPI.repositories.RepRecuperaLogin;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/RecuperaLogin")
@CrossOrigin("*")
public class RecuperaLoginController {

    @Autowired
    RepRecuperaLogin repRecuperaLogin;

    @PostMapping
    public ResponseEntity<RecuperaLogin> saveRecuperaLogin(@RequestBody @Valid RecuperaLoginRecordDto recuperaLoginRecordDto) {

        var recuperaLogin = new RecuperaLogin();
        BeanUtils.copyProperties(recuperaLoginRecordDto, recuperaLogin);
        recuperaLogin.setIdRecuperaLogin(UUID.randomUUID());

        return ResponseEntity.status(HttpStatus.CREATED).body(repRecuperaLogin.save(recuperaLogin));
    }


    @GetMapping("/{id}")
    public ResponseEntity<RecuperaLogin> getRecuperaLoginById(@PathVariable UUID id) {
        var recuperaLogin = repRecuperaLogin.findById(id);

        if (recuperaLogin.isPresent()) {
            return ResponseEntity.ok(recuperaLogin.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RecuperaLogin>> getAllRecuperaLogins() {
        var recuperaLogins = repRecuperaLogin.findAll();
        return ResponseEntity.ok(recuperaLogins);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecuperaLogin> updateRecuperaLogin(@PathVariable UUID id, @RequestBody @Valid RecuperaLoginRecordDto recuperaLoginRecordDto) {
        var existingRecuperaLogin = repRecuperaLogin.findById(id);

        if (existingRecuperaLogin.isPresent()) {
            var recuperaLogin = existingRecuperaLogin.get();
            BeanUtils.copyProperties(recuperaLoginRecordDto, recuperaLogin);
            recuperaLogin.setIdRecuperaLogin(id);
            return ResponseEntity.ok(repRecuperaLogin.save(recuperaLogin));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecuperaLogin(@PathVariable UUID id) {
        var recuperaLogin = repRecuperaLogin.findById(id);

        if (recuperaLogin.isPresent()) {
            repRecuperaLogin.delete(recuperaLogin.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
