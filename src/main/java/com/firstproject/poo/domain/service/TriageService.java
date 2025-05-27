package com.firstproject.poo.domain.service;

import com.firstproject.poo.domain.dto.TriageEvaluation;
import com.firstproject.poo.domain.dto.SymptomRequest;
import com.firstproject.poo.domain.dto.TriageResult;
import com.firstproject.poo.domain.repository.TriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TriageService {
    @Autowired
    private TriageRepository triageRepo;

    public TriageResult evaluateSymptoms(SymptomRequest request) {
        TriageResult result = new TriageResult();
        List<String> symptoms = request.getSymptoms();

        List<String> lowerSymptoms = symptoms.stream()
                .map(String::toLowerCase)
                .toList();

        // PRIORITY 1 - IMMEDIATE/EMERGENCY
        if (isEmergencyCase(lowerSymptoms)) {
            result.setSpecialty(determineEmergencySpecialty(lowerSymptoms));
            result.setPriority("IMMEDIATE");
            result.setRecommendation("EMERGENCY - Seek immediate medical attention");
            return result;
        }

        // PRIORITY 2 - URGENT (Delayed - YELLOW)
        if (isUrgentCase(lowerSymptoms)) {
            result.setSpecialty(determineUrgentSpecialty(lowerSymptoms));
            result.setPriority("URGENT");
            result.setRecommendation("URGENT - Seek medical attention within 1-2 hours");
            return result;
        }

        // PRIORITY 3 - MINIMAL (Minor injuries - GREEN)
        if (isMinimalCase(lowerSymptoms)) {
            result.setSpecialty(determineMinimalSpecialty(lowerSymptoms));
            result.setPriority("MINIMAL");
            result.setRecommendation("MINIMAL - Can wait, seek care within 24 hours");
            return result;
        }

        // DEFAULT - EXPECTANT/ROUTINE (BLACK/LOW)
        result.setSpecialty(determineRoutineSpecialty(lowerSymptoms));
        result.setPriority("EXPECTANT");
        result.setRecommendation("ROUTINE - Schedule regular appointment");

        return result;
    }

    // EMERGENCY CASES (RED - Priority 1)
    private boolean isEmergencyCase(List<String> symptoms) {
        List<String> emergencySymptoms = Arrays.asList(
                "chest_pain", "chest pain", "severe chest pain",
                "difficulty_breathing", "shortness of breath", "can't breathe",
                "unconscious", "unresponsive", "not responding",
                "severe_bleeding", "heavy bleeding", "bleeding heavily",
                "stroke_symptoms", "can't speak", "face drooping",
                "severe_abdominal_pain", "severe stomach pain",
                "poisoning", "overdose", "drug overdose",
                "severe_burns", "major burns",
                "severe_trauma", "major accident", "car accident",
                "heart_attack", "cardiac arrest",
                "seizure", "convulsions",
                "severe_allergic_reaction", "anaphylaxis"
        );

        return symptoms.stream().anyMatch(emergencySymptoms::contains) ||
                (symptoms.contains("severe") && symptoms.contains("pain")) ||
                (symptoms.contains("high") && symptoms.contains("fever") && symptoms.size() >= 3);
    }

    // URGENT CASES (YELLOW - Priority 2)
    private boolean isUrgentCase(List<String> symptoms) {
        List<String> urgentSymptoms = Arrays.asList(
                "moderate_pain", "significant pain", "bad pain",
                "high_fever", "fever", "temperature",
                "vomiting", "throwing up", "nausea",
                "persistent_cough", "bad cough", "cough",
                "infection_signs", "swelling", "redness",
                "moderate_bleeding", "bleeding",
                "dehydration", "very thirsty", "dry mouth",
                "abdominal_pain", "stomach pain", "belly pain",
                "headache", "migraine", "head pain",
                "back_pain", "spine pain",
                "joint_pain", "arthritis pain",
                "eye_problems", "vision problems", "can't see well",
                "ear_pain", "hearing problems"
        );

        return symptoms.stream().anyMatch(urgentSymptoms::contains) ||
                (symptoms.contains("fever") && symptoms.contains("cough")) ||
                (symptoms.contains("pain") && symptoms.size() >= 2);
    }

    // MINIMAL CASES (GREEN - Priority 3)
    private boolean isMinimalCase(List<String> symptoms) {
        List<String> minimalSymptoms = Arrays.asList(
                "minor_cut", "small cut", "scratch",
                "bruise", "minor bruising",
                "cold_symptoms", "runny nose", "sneezing",
                "minor_headache", "slight headache",
                "minor_rash", "skin irritation",
                "minor_sprain", "twisted ankle",
                "minor_burn", "small burn",
                "fatigue", "tired", "exhausted",
                "minor_nausea", "slightly sick",
                "minor_dizziness", "lightheaded"
        );

        return symptoms.stream().anyMatch(minimalSymptoms::contains) ||
                (symptoms.size() == 1 && !isUrgentCase(symptoms) && !isEmergencyCase(symptoms));
    }

    // Specialty determination for EMERGENCY cases
    private String determineEmergencySpecialty(List<String> symptoms) {
        if (symptoms.stream().anyMatch(s -> s.contains("chest") || s.contains("heart") || s.contains("cardiac"))) {
            return "EMERGENCY_CARDIOLOGY";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("stroke") || s.contains("neurological"))) {
            return "EMERGENCY_NEUROLOGY";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("trauma") || s.contains("accident") || s.contains("bleeding"))) {
            return "EMERGENCY_SURGERY";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("breathing") || s.contains("respiratory"))) {
            return "EMERGENCY_RESPIRATORY";
        }
        return "EMERGENCY_MEDICINE";
    }

    // Specialty determination for URGENT cases
    private String determineUrgentSpecialty(List<String> symptoms) {
        if (symptoms.stream().anyMatch(s -> s.contains("chest") || s.contains("heart"))) {
            return "CARDIOLOGY";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("headache") || s.contains("neurological"))) {
            return "NEUROLOGY";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("stomach") || s.contains("abdominal") || s.contains("digestive"))) {
            return "GASTROENTEROLOGY";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("joint") || s.contains("bone") || s.contains("back"))) {
            return "ORTHOPEDICS";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("eye") || s.contains("vision"))) {
            return "OPHTHALMOLOGY";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("ear") || s.contains("hearing"))) {
            return "ENT";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("skin") || s.contains("rash"))) {
            return "DERMATOLOGY";
        }
        return "INTERNAL_MEDICINE";
    }

    // Specialty determination for minimal cases
    private String determineMinimalSpecialty(List<String> symptoms) {
        if (symptoms.stream().anyMatch(s -> s.contains("skin") || s.contains("rash") || s.contains("cut"))) {
            return "DERMATOLOGY";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("cold") || s.contains("cough") || s.contains("respiratory"))) {
            return "FAMILY_MEDICINE";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("sprain") || s.contains("joint") || s.contains("muscle"))) {
            return "SPORTS_MEDICINE";
        }
        return "GENERAL_PRACTICE";
    }

    // Specialty determination for normal cases
    private String determineRoutineSpecialty(List<String> symptoms) {
        if (symptoms.isEmpty()) {
            return "GENERAL_PRACTICE";
        }

        if (symptoms.stream().anyMatch(s -> s.contains("check") || s.contains("routine"))) {
            return "PREVENTIVE_MEDICINE";
        }
        if (symptoms.stream().anyMatch(s -> s.contains("mental") || s.contains("stress") || s.contains("anxiety"))) {
            return "PSYCHIATRY";
        }

        return "GENERAL_PRACTICE";
    }

    public String createAutoAppointment(SymptomRequest request) {
        TriageResult triage = evaluateSymptoms(request);

        // Save evaluation to database
        TriageEvaluation evaluation = new TriageEvaluation();
        evaluation.setPatientName(request.getPatientName());
        evaluation.setSymptoms(request.getSymptoms());
        evaluation.setRecommendedSpeciality(triage.getSpecialty());
        evaluation.setPriority(triage.getPriority());
        evaluation.setStatus("APPOINTMENT_SCHEDULED");
        evaluation.setEvaluationDate(LocalDateTime.now());
        evaluation.setSeverity(calculateSeverityScore(triage.getPriority()));

        triageRepo.save(evaluation);

        return generateAppointmentMessage(triage, request.getPatientName());
    }

    private String generateAppointmentMessage(TriageResult triage, String patientName) {
        String timeframe = switch (triage.getPriority()) {
            case "IMMEDIATE" -> "IMMEDIATELY - Go to Emergency Room NOW";
            case "URGENT" -> "within 1-2 hours";
            case "MINIMAL" -> "within 24 hours";
            case "EXPECTANT" -> "within 1-2 weeks";
            default -> "as soon as possible";
        };

        return String.format("🏥 APPOINTMENT SCHEDULED for %s\n" +
                        "📋 Specialty: %s\n" +
                        "🚨 Priority: %s\n" +
                        "⏰ Timeframe: %s\n" +
                        "💡 Recommendation: %s",
                patientName,
                triage.getSpecialty(),
                triage.getPriority(),
                timeframe,
                triage.getRecommendation());
    }

    private Integer calculateSeverityScore(String priority) {
        return switch (priority) {
            case "IMMEDIATE" -> 10;
            case "URGENT" -> 7;
            case "MINIMAL" -> 4;
            case "EXPECTANT" -> 2;
            default -> 1;
        };
    }

    // Existing CRUD methods remain the same
    public List<TriageEvaluation> getAll() {
        return triageRepo.getAll();
    }

    public Optional<TriageEvaluation> getByID(long evaluationID) {
        return triageRepo.getById(evaluationID);
    }

    public TriageEvaluation save(TriageEvaluation evaluation) {
        return triageRepo.save(evaluation);
    }

    public boolean delete(long evaluationID) {
        if (getByID(evaluationID).isPresent()) {
            triageRepo.delete(evaluationID);
            return true;
        }
        return false;
    }

    public List<TriageEvaluation> getByPriority(String priority) {
        return triageRepo.getByPriority(priority);
    }
}