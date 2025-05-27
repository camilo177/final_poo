package com.firstproject.poo.domain.repository;

import com.firstproject.poo.domain.dto.TriageEvaluation;

import java.util.List;
import java.util.Optional;

public interface TriageRepository {
    List<TriageEvaluation> getAll();
    List<TriageEvaluation> getByPriority(String priority); 
    Optional<TriageEvaluation> getById(long idEvaluation);
    TriageEvaluation save(TriageEvaluation evaluation);
    void delete(long idEvaluation);
}