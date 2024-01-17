package com.mediLaboSolutions.backendriskassessment.proxies;

import com.mediLaboSolutions.backendriskassessment.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client interface for interacting with the MS-BACKEND-PATIENT-MANAGEMENT microservice.
 */
@FeignClient(name = "MS-BACKEND-PATIENT-MANAGEMENT")
public interface MSBackendPatientManagement {

    /**
     * Retrieves patient information from the MS-BACKEND-PATIENT-MANAGEMENT microservice.
     *
     * @param id the ID of the patient to retrieve information for
     * @return the PatientBean representing the patient's information
     */
    @GetMapping(value = "/patients/{id}")
    PatientBean patientInfos(@PathVariable Integer id);
}
