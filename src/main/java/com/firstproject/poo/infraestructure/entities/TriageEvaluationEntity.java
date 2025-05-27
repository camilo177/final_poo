package com.firstproject.poo.infraestructure.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "triage_evaluations")  
public class TriageEvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluation")  
    private Long idEvaluation;

    @Column(name = "patient_name")  
    private String patientName;
    
    @Column(name = "symptoms") 
    private String symptomsString;  
    
    private Integer severity;  
    
    @Column(name = "recommended_speciality")
    private String recommendedSpeciality;
    
    private String priority;
    private String status;
    
    @Column(name = "evaluation_date")
    private LocalDateTime evaluationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient", nullable = true) 
    private PatientEntity patient;  

    public Long getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSymptomsString() {
        return symptomsString;
    }

    public void setSymptomsString(String symptomsString) {
        this.symptomsString = symptomsString;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getRecommendedSpeciality() {
        return recommendedSpeciality;
    }

    public void setRecommendedSpeciality(String recommendedSpeciality) {
        this.recommendedSpeciality = recommendedSpeciality;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDateTime evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
}