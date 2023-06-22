package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.CliFornecServicoRecordDto;
import com.constructor.constructorAPI.models.CliFornecServico;
import com.constructor.constructorAPI.repositories.RepCliFornecServico;
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
@RequestMapping("/CliFornecServico")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CliFornecServicoController {

    @Autowired
    private RepCliFornecServico repCliFornecServico;

    @PostMapping
    public ResponseEntity<CliFornecServico> saveCliFornecServico(@RequestBody @Valid CliFornecServicoRecordDto cliFornecServicoRecordDto) {
        var cliFornecServico = new CliFornecServico();
        BeanUtils.copyProperties(cliFornecServicoRecordDto, cliFornecServico);
        cliFornecServico.setIdCliFornecServico(UUID.randomUUID()); // Gera um novo UUID para o CliFornecServico
        return ResponseEntity.status(HttpStatus.CREATED).body(repCliFornecServico.save(cliFornecServico));
    }

    @GetMapping
    public ResponseEntity<List<CliFornecServico>> getCliFornecServicos() {
        List<CliFornecServico> cliFornecServicos = repCliFornecServico.findAll();
        return ResponseEntity.ok(cliFornecServicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CliFornecServico> getCliFornecServicoById(@PathVariable UUID id) {
        Optional<CliFornecServico> optionalCliFornecServico = repCliFornecServico.findById(id);
        if (optionalCliFornecServico.isPresent()) {
            return ResponseEntity.ok(optionalCliFornecServico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CliFornecServico> updateCliFornecServico(@PathVariable UUID id, @RequestBody @Valid CliFornecServicoRecordDto cliFornecServicoRecordDto) {
        Optional<CliFornecServico> optionalCliFornecServico = repCliFornecServico.findById(id);
        if (optionalCliFornecServico.isPresent()) {
            CliFornecServico cliFornecServico = optionalCliFornecServico.get();
            BeanUtils.copyProperties(cliFornecServicoRecordDto, cliFornecServico);
            return ResponseEntity.ok(repCliFornecServico.save(cliFornecServico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliFornecServico(@PathVariable UUID id) {
        Optional<CliFornecServico> optionalCliFornecServico = repCliFornecServico.findById(id);
        if (optionalCliFornecServico.isPresent()) {
            repCliFornecServico.delete(optionalCliFornecServico.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}