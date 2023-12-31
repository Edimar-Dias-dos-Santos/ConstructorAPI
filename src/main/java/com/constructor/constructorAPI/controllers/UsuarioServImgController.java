package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.UsuarioServImgRecordDto;
import com.constructor.constructorAPI.dtos.models.UsuarioServImg;
import com.constructor.constructorAPI.repositories.RepUsuarioServImg;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/UsuarioServImg")
@CrossOrigin("*")
public class UsuarioServImgController {

    @Autowired
    private RepUsuarioServImg repUsuarioServImg;

    @PostMapping("/{idCliFornec}/image")
    public ResponseEntity<UsuarioServImg> saveUsuarioServImg(
            @PathVariable UUID idCliFornec,
            @RequestParam("imageFile") MultipartFile imageFile) {

        var usuarioServImg = new UsuarioServImg();
        usuarioServImg.setIdCliFornec(idCliFornec);

        try {
            usuarioServImg.saveImage(idCliFornec, imageFile);
        } catch (IOException e) {
            // Trate a exceção de forma adequada para sua aplicação
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(repUsuarioServImg.save(usuarioServImg));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioServImg>> getUsuarioServImgs() {
        List<UsuarioServImg> usuarioServImgs = repUsuarioServImg.findAll();
        return ResponseEntity.ok(usuarioServImgs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioServImg> getUsuarioServImgById(@PathVariable UUID id) {
        Optional<UsuarioServImg> optionalUsuarioServImg = repUsuarioServImg.findById(id);
        if (optionalUsuarioServImg.isPresent()) {
            return ResponseEntity.ok(optionalUsuarioServImg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioServImg> updateUsuarioServImg(
            @PathVariable UUID id,
            @RequestBody @Valid UsuarioServImgRecordDto usuarioServImgRecordDto) {

        Optional<UsuarioServImg> optionalUsuarioServImg = repUsuarioServImg.findById(id);
        if (optionalUsuarioServImg.isPresent()) {
            UsuarioServImg usuarioServImg = optionalUsuarioServImg.get();
            BeanUtils.copyProperties(usuarioServImgRecordDto, usuarioServImg);
            return ResponseEntity.ok(repUsuarioServImg.save(usuarioServImg));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioServImg(@PathVariable UUID id) {
        Optional<UsuarioServImg> optionalUsuarioServImg = repUsuarioServImg.findById(id);
        if (optionalUsuarioServImg.isPresent()) {
            repUsuarioServImg.delete(optionalUsuarioServImg.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}