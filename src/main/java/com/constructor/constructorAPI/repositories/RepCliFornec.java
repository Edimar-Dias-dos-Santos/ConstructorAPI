package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.models.CliFornec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepCliFornec extends JpaRepository<CliFornec, UUID> {
}