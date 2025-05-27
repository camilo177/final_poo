package com.firstproject.poo.domain.repository;

import com.firstproject.poo.domain.dto.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    List<Patient> getAll();
    Optional<Patient> getById(long idPatient);
    void deleteByID(long idPatient);
    Patient save(Patient patient);
}