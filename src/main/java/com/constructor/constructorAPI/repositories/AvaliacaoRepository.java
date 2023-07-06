package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.dtos.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, UUID> {
    Avaliacao findByIdUsuario(UUID idUsuario);
}