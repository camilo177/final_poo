package com.firstproject.poo.infraestructure.repositories;

import com.firstproject.poo.infraestructure.entities.TriageEvaluationEntity;  // renamed from Libro
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TriageEvaluationCrudRepository extends CrudRepository<TriageEvaluationEntity, Long> {
    List<TriageEvaluationEntity> findByPriority(String priority);
}