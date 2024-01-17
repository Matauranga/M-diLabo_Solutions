package com.mediLaboSolutions.backendriskassessment.services;

import com.mediLaboSolutions.backendriskassessment.DTO.AssessmentResultDTO;

public interface AssessmentRiskService {

    /**
     * Retrieves the risk assessment result for a specific patient.
     *
     * @param patientId the ID of the patient for whom to perform the risk assessment
     * @return the AssessmentResultDTO representing the result of the risk assessment
     */
    AssessmentResultDTO getRiskAssessmentResult(Integer patientId);
}
