package com.constructor.constructorAPI.controllers;

import com.constructor.constructorAPI.dtos.SugestaoAdmDto;
import com.constructor.constructorAPI.models.SugestaoAdm;
import com.constructor.constructorAPI.repositories.SugestaoAdmRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/SugestaoAdm")
@CrossOrigin("*")
public class SugestaoAdmController {

    @Autowired
    private SugestaoAdmRepository sugestaoAdmRepository;

    @PostMapping
    public ResponseEntity<SugestaoAdm> createSugestaoAdm(@RequestBody @Valid SugestaoAdmDto sugestaoAdmDto) {
        var sugestaoAdm = new SugestaoAdm();
        BeanUtils.copyProperties(sugestaoAdmDto, sugestaoAdm);
        return ResponseEntity.status(HttpStatus.CREATED).body(sugestaoAdmRepository.save(sugestaoAdm));
    }

    @GetMapping
    public ResponseEntity<List<SugestaoAdm>> getAllSugestaoAdm() {
        List<SugestaoAdm> sugestaoAdmList = sugestaoAdmRepository.findAll();
        return ResponseEntity.ok(sugestaoAdmList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SugestaoAdm> getSugestaoAdmById(@PathVariable Long id) {
        Optional<SugestaoAdm> optionalSugestaoAdm = sugestaoAdmRepository.findById(id);
        if (optionalSugestaoAdm.isPresent()) {
            return ResponseEntity.ok(optionalSugestaoAdm.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SugestaoAdm> updateSugestaoAdm(@PathVariable Long id, @RequestBody @Valid SugestaoAdmDto sugestaoAdmDto) {
        Optional<SugestaoAdm> optionalSugestaoAdm = sugestaoAdmRepository.findById(id);
        if (optionalSugestaoAdm.isPresent()) {
            SugestaoAdm sugestaoAdm = optionalSugestaoAdm.get();
            BeanUtils.copyProperties(sugestaoAdmDto, sugestaoAdm);
            return ResponseEntity.ok(sugestaoAdmRepository.save(sugestaoAdm));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSugestaoAdm(@PathVariable Long id) {
        Optional<SugestaoAdm> optionalSugestaoAdm = sugestaoAdmRepository.findById(id);
        if (optionalSugestaoAdm.isPresent()) {
            sugestaoAdmRepository.delete(optionalSugestaoAdm.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}