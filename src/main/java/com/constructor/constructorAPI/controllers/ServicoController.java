package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.ServicoRecordDto;
import com.constructor.constructorAPI.dtos.models.Servico;
import com.constructor.constructorAPI.repositories.RepServico;
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
@RequestMapping("api/Servico")
@CrossOrigin("*")
public class ServicoController {

    @Autowired
    private RepServico repServico;

    @PostMapping
    public ResponseEntity<Servico> saveServico(@RequestBody @Valid ServicoRecordDto servicoRecordDto) {
        var servico = new Servico();
        BeanUtils.copyProperties(servicoRecordDto, servico);
        servico.setIdServico(UUID.randomUUID()); // Gera um novo UUID para o Servico
        return ResponseEntity.status(HttpStatus.CREATED).body(repServico.save(servico));
    }

    @GetMapping
    public ResponseEntity<List<Servico>> getServicos() {
        List<Servico> servicos = repServico.findAll();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable UUID id) {
        Optional<Servico> optionalServico = repServico.findById(id);
        if (optionalServico.isPresent()) {
            return ResponseEntity.ok(optionalServico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable UUID id, @RequestBody @Valid ServicoRecordDto servicoRecordDto) {
        Optional<Servico> optionalServico = repServico.findById(id);
        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            BeanUtils.copyProperties(servicoRecordDto, servico);
            return ResponseEntity.ok(repServico.save(servico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable UUID id) {
        Optional<Servico> optionalServico = repServico.findById(id);
        if (optionalServico.isPresent()) {
            repServico.delete(optionalServico.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}