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

    @GetMapping("/result/{id}")
    public AssessmentResultDTO getResult(@PathVariable Integer id) {

        return assessmentRiskService.getResult(id);
    }

    @GetMapping("/res/{id}")
    public AssessmentResultDTO getResult2(@PathVariable Integer id) {

        return assessmentRiskService.getResult2(id);
    }
}
