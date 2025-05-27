package com.firstproject.poo.infraestructure;

import com.firstproject.poo.domain.dto.Patient;
import com.firstproject.poo.domain.repository.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    @Override
    public List<Patient> getAll() {
        return List.of();  
    }

    @Override
    public Optional<Patient> getById(long idPatient) {
        return Optional.empty();  
    }

    @Override
    public void deleteByID(long idPatient) {
    }

    @Override
    public Patient save(Patient patient) {
        return patient; 
    }
}