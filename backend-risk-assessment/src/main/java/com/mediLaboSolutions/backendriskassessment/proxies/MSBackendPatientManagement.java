package com.mediLaboSolutions.backendriskassessment.proxies;

import com.mediLaboSolutions.backendriskassessment.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-BACKEND-PATIENT-MANAGEMENT")
public interface MSBackendPatientManagement {

    /**
     *  ALL ENDPOINT --> BACKEND PATIENT MANAGEMENT
     */

    @GetMapping(value = "/patients/{id}")
    PatientBean patientInfos(@PathVariable Integer id);

}
