package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.dtos.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepServico extends JpaRepository<Servico, UUID> {
}