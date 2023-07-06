package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.dtos.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepUsuario extends JpaRepository<Usuario, UUID> {
}
