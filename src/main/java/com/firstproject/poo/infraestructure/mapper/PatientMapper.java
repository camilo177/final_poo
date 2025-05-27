package com.firstproject.poo.infraestructure.mapper;

import com.firstproject.poo.domain.dto.Patient;
import com.firstproject.poo.infraestructure.entities.PatientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    
    @Mappings({
            @Mapping(source = "idPatient", target = "patientId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email")
    })
    Patient toPatient(PatientEntity entity);

    @InheritInverseConfiguration
    @Mapping(target = "evaluations", ignore = true) 
    PatientEntity toEntity(Patient patient);
}