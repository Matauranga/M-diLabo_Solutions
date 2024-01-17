package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.beans.RiskAssessmentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client interface for communicating with the Risk Assessment Service through the Gateway.
 */
@FeignClient(name = "MS-GATEWAY-RISK", url = "${ms.gateway.url}")
public interface MSGatewayRiskAssessmentService {

    /**
     * Retrieves the risk assessment result for a specific patient.
     *
     * @param id the ID of the patient
     * @return the risk assessment result for the specified patient
     */
    @GetMapping(value = "/risk-assessment/{id}")
    RiskAssessmentBean getRiskAssessmentResult(@PathVariable Integer id);
}
