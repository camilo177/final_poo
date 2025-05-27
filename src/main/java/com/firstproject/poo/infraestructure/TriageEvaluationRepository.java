package com.firstproject.poo.infraestructure;

import com.firstproject.poo.domain.dto.TriageEvaluation;
import com.firstproject.poo.domain.repository.TriageRepository;
import com.firstproject.poo.infraestructure.entities.TriageEvaluationEntity;
import com.firstproject.poo.infraestructure.mapper.TriageMapper;
import com.firstproject.poo.infraestructure.repositories.TriageEvaluationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TriageEvaluationRepository implements TriageRepository {
    @Autowired
    public TriageEvaluationCrudRepository triageRepo;
    
    @Autowired
    public TriageMapper mapper;

    @Override
    public List<TriageEvaluation> getAll() {
        List<TriageEvaluationEntity> entities = (List<TriageEvaluationEntity>) triageRepo.findAll();
        return mapper.toTriageEvaluations(entities);
    }

    @Override
    public List<TriageEvaluation> getByPriority(String priority) {
        List<TriageEvaluationEntity> entities = (List<TriageEvaluationEntity>) triageRepo.findByPriority(priority);
        return mapper.toTriageEvaluations(entities);
    }

    @Override
    public Optional<TriageEvaluation> getById(long idEvaluation) {
        Optional<TriageEvaluationEntity> entity = triageRepo.findById(idEvaluation);
        return mapper.toTriageEvaluationOptional(entity);
    }

    @Override
    public TriageEvaluation save(TriageEvaluation evaluation) {
        TriageEvaluationEntity entity = mapper.toEntity(evaluation);
        return mapper.toTriageEvaluation(triageRepo.save(entity));
    }

    @Override
    public void delete(long idEvaluation) {
        triageRepo.deleteById(idEvaluation);
    }
}