package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.models.UsuarioServImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepUsuarioServImg extends JpaRepository<UsuarioServImg, UUID> {
}