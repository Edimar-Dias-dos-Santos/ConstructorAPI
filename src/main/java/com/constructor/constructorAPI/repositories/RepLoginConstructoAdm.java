package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.dtos.models.LoginConstructoAdm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepLoginConstructoAdm extends JpaRepository<LoginConstructoAdm, UUID> {
    Optional<LoginConstructoAdm> findByUsernameAndPassword(String username, String password);
}