package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepLogin extends JpaRepository<Login, UUID> {
    Optional<Login> findByUsernameAndPassword(String username, String password);
}