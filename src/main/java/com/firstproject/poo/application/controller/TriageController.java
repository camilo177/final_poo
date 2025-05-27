package com.firstproject.poo.application.controller;

import com.firstproject.poo.domain.dto.TriageEvaluation;
import com.firstproject.poo.domain.dto.SymptomRequest;
import com.firstproject.poo.domain.dto.TriageResult;
import com.firstproject.poo.domain.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/triage")
public class TriageController {
    @Autowired
    private TriageService triageService; 

    @PostMapping
    public ResponseEntity<TriageResult> evaluateSymptoms(@RequestBody SymptomRequest request) {
        return new ResponseEntity<>(triageService.evaluateSymptoms(request), HttpStatus.OK);
    }
    
    @PostMapping("/auto-cita")
    public ResponseEntity<String> createAutoAppointment(@RequestBody SymptomRequest request) {
        return new ResponseEntity<>(triageService.createAutoAppointment(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TriageEvaluation>> getAll() {
        return new ResponseEntity<>(triageService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TriageEvaluation> getByID(@PathVariable("id") long evaluationID) {  
        return triageService.getByID(evaluationID)
                .map(evaluation -> new ResponseEntity<>(evaluation, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/evaluation") 
    public ResponseEntity<TriageEvaluation> save(@RequestBody TriageEvaluation evaluation) {
        return new ResponseEntity<>(triageService.save(evaluation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long evaluationID) {  
        if (triageService.delete(evaluationID)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<TriageEvaluation>> getByPriority(@PathVariable String priority) {
        return new ResponseEntity<>(triageService.getByPriority(priority), HttpStatus.OK);
    }
}