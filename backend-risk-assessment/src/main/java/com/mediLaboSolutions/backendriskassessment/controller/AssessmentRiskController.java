package com.mediLaboSolutions.backendriskassessment.controller;

import com.mediLaboSolutions.backendriskassessment.DTO.AssessmentResultDTO;
import com.mediLaboSolutions.backendriskassessment.services.AssessmentRiskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssessmentRiskController {
    private final AssessmentRiskService assessmentRiskService;

    public AssessmentRiskController(AssessmentRiskService assessmentRiskService) {
        this.assessmentRiskService = assessmentRiskService;
    }

    /**
     * Handles HTTP GET request for retrieving the risk assessment result for a specific patient.
     *
     * @param id the ID of the patient for whom to perform the risk assessment
     * @return the AssessmentResultDTO representing the result of the risk assessment
     */
    @GetMapping("/risk-assessment/{id}")
    public AssessmentResultDTO getRiskAssessmentResult(@PathVariable Integer id) {
        return assessmentRiskService.getRiskAssessmentResult(id);
    }
}
