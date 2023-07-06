package com.constructor.constructorAPI.repositories;

import com.constructor.constructorAPI.dtos.models.SugestaoAdm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoAdmRepository extends JpaRepository<SugestaoAdm, Long> {
}