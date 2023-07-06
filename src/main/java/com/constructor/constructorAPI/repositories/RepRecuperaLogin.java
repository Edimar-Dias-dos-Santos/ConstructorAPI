package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.dtos.models.RecuperaLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepRecuperaLogin extends JpaRepository<RecuperaLogin, UUID> {

}