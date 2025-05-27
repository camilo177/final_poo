
package com.firstproject.poo.domain.dto;

import java.util.List;

public class SymptomRequest {
    private String patientName;
    private List<String> symptoms;
    
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
    
    
}

