package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.models.UsuarioPerfilImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepUsuarioPerfilImg extends JpaRepository<UsuarioPerfilImg, UUID> {
}