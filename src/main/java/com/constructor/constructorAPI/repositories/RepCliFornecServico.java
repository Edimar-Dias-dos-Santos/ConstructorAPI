package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.models.CliFornecServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepCliFornecServico extends JpaRepository<CliFornecServico, UUID> {
}