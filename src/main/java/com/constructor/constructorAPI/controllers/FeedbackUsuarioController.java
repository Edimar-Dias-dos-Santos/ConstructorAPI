package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.FeedbackUsuarioRecordDto;
import com.constructor.constructorAPI.dtos.models.FeedbackUsuario;
import com.constructor.constructorAPI.repositories.RepFeedbackUsuario;
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
@RequestMapping("api/FeedbackUsuario")
@CrossOrigin("*")
public class FeedbackUsuarioController {

    @Autowired
    private RepFeedbackUsuario repFeedbackUsuario;

    @PostMapping
    public ResponseEntity<FeedbackUsuario> saveFeedbackUsuario(@RequestBody @Valid FeedbackUsuarioRecordDto feedbackUsuarioRecordDto) {
        var feedbackUsuario = new FeedbackUsuario();
        BeanUtils.copyProperties(feedbackUsuarioRecordDto, feedbackUsuario);
        feedbackUsuario.setIdFeedback(UUID.randomUUID()); // Gera um novo UUID para o FeedbackUsuario
        return ResponseEntity.status(HttpStatus.CREATED).body(repFeedbackUsuario.save(feedbackUsuario));
    }

    @GetMapping
    public ResponseEntity<List<FeedbackUsuario>> getFeedbackUsuarios() {
        List<FeedbackUsuario> feedbackUsuarios = repFeedbackUsuario.findAll();
        return ResponseEntity.ok(feedbackUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackUsuario> getFeedbackUsuarioById(@PathVariable UUID id) {
        Optional<FeedbackUsuario> optionalFeedbackUsuario = repFeedbackUsuario.findById(id);
        if (optionalFeedbackUsuario.isPresent()) {
            return ResponseEntity.ok(optionalFeedbackUsuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackUsuario> updateFeedbackUsuario(@PathVariable UUID id, @RequestBody @Valid FeedbackUsuarioRecordDto feedbackUsuarioRecordDto) {
        Optional<FeedbackUsuario> optionalFeedbackUsuario = repFeedbackUsuario.findById(id);
        if (optionalFeedbackUsuario.isPresent()) {
            FeedbackUsuario feedbackUsuario = optionalFeedbackUsuario.get();
            BeanUtils.copyProperties(feedbackUsuarioRecordDto, feedbackUsuario);
            return ResponseEntity.ok(repFeedbackUsuario.save(feedbackUsuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedbackUsuario(@PathVariable UUID id) {
        Optional<FeedbackUsuario> optionalFeedbackUsuario = repFeedbackUsuario.findById(id);
        if (optionalFeedbackUsuario.isPresent()) {
            repFeedbackUsuario.delete(optionalFeedbackUsuario.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
