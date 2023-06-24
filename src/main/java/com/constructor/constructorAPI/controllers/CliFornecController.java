package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.CliFornecRecordDto;
import com.constructor.constructorAPI.models.CliFornec;
import com.constructor.constructorAPI.repositories.RepCliFornec;
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
@RequestMapping("api/CliFornec")
@CrossOrigin("*")
public class CliFornecController {

    @Autowired
    private RepCliFornec repCliFornec;

    @PostMapping
    public ResponseEntity<CliFornec> saveCliFornec(@RequestBody @Valid CliFornecRecordDto cliFornecRecordDto) {
        var cliFornec = new CliFornec();
        BeanUtils.copyProperties(cliFornecRecordDto, cliFornec);
        cliFornec.setIdCliFornec(UUID.randomUUID()); // Gera um novo UUID para o CliFornec
        return ResponseEntity.status(HttpStatus.CREATED).body(repCliFornec.save(cliFornec));
    }

    @GetMapping
    public ResponseEntity<List<CliFornec>> getCliFornecs() {
        List<CliFornec> cliFornecs = repCliFornec.findAll();
        return ResponseEntity.ok(cliFornecs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CliFornec> getCliFornecById(@PathVariable UUID id) {
        Optional<CliFornec> optionalCliFornec = repCliFornec.findById(id);
        if (optionalCliFornec.isPresent()) {
            return ResponseEntity.ok(optionalCliFornec.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CliFornec> updateCliFornec(@PathVariable UUID id, @RequestBody @Valid CliFornecRecordDto cliFornecRecordDto) {
        Optional<CliFornec> optionalCliFornec = repCliFornec.findById(id);
        if (optionalCliFornec.isPresent()) {
            CliFornec cliFornec = optionalCliFornec.get();
            BeanUtils.copyProperties(cliFornecRecordDto, cliFornec);
            return ResponseEntity.ok(repCliFornec.save(cliFornec));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliFornec(@PathVariable UUID id) {
        Optional<CliFornec> optionalCliFornec = repCliFornec.findById(id);
        if (optionalCliFornec.isPresent()) {
            repCliFornec.delete(optionalCliFornec.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}