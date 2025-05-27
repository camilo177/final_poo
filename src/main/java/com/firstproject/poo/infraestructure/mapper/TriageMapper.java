package com.firstproject.poo.infraestructure.mapper;

import com.firstproject.poo.domain.dto.TriageEvaluation;
import com.firstproject.poo.infraestructure.entities.TriageEvaluationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {PatientMapper.class})
public interface TriageMapper {
    
    @Mappings({
            @Mapping(source = "idEvaluation", target = "evaluationID"),
            @Mapping(source = "patientName", target = "patientName"),
            @Mapping(source = "symptomsString", target = "symptoms", qualifiedByName = "stringToList"),
            @Mapping(source = "severity", target = "severity"),
            @Mapping(source = "recommendedSpeciality", target = "recommendedSpeciality"),
            @Mapping(source = "priority", target = "priority"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "evaluationDate", target = "evaluationDate")    
        })
    TriageEvaluation toTriageEvaluation(TriageEvaluationEntity entity);
    
    List<TriageEvaluation> toTriageEvaluations(List<TriageEvaluationEntity> entities);
    
    default Optional<TriageEvaluation> toTriageEvaluationOptional(Optional<TriageEvaluationEntity> entity) {
        return entity.map(this::toTriageEvaluation);
    }
    
    @InheritInverseConfiguration
    @Mapping(source = "symptoms", target = "symptomsString", qualifiedByName = "listToString")
    TriageEvaluationEntity toEntity(TriageEvaluation evaluation);
    
    @org.mapstruct.Named("stringToList")
    default List<String> stringToList(String symptomsString) {
        if (symptomsString == null || symptomsString.trim().isEmpty()) {
            return List.of();
        }
        return Arrays.asList(symptomsString.split(","));
    }
    
    @org.mapstruct.Named("listToString") 
    default String listToString(List<String> symptoms) {
        if (symptoms == null || symptoms.isEmpty()) {
            return "";
        }
        return String.join(",", symptoms);
    }
}