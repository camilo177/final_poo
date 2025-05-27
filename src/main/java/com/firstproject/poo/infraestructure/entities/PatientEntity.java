package com.firstproject.poo.infraestructure.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "patients")  
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")  
    private Long idPatient;

    private String name;  
    private String email;  

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TriageEvaluationEntity> evaluations;  

 
    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TriageEvaluationEntity> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<TriageEvaluationEntity> evaluations) {
        this.evaluations = evaluations;
    }
}