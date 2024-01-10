package com.mediLaboSolutions.backendriskassessment.services;

import com.mediLaboSolutions.backendriskassessment.DTO.AssessmentResultDTO;

public interface AssessmentRiskService {
    AssessmentResultDTO getRiskAssessmentResult(Integer patientId);

}
