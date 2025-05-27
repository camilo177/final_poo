package com.firstproject.poo.domain.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TriageEvaluation {
    private Long evaluationID;
    private String patientName;
    private List<String> symptoms;
    private Integer severity;
    private String recommendedSpeciality;
    private String priority;
    private String status;
    private LocalDateTime evaluationDate;
    
    public Long getEvaluationID() {
        return evaluationID;
    }
    public void setEvaluationID(Long evaluationID) {
        this.evaluationID = evaluationID;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public List<String> getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
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
}   
