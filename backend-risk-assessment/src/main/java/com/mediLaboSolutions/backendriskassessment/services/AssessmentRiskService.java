package com.mediLaboSolutions.backendriskassessment.services;

import com.mediLaboSolutions.backendriskassessment.DTO.AssessmentResultDTO;

public interface AssessmentRiskService {
    public AssessmentResultDTO getResult(Integer patientId);

    public AssessmentResultDTO getResult2(Integer patientId);

}
