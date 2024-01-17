package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * Feign client interface for communicating with the Patient Service through the Gateway.
 */
@FeignClient(name = "MS-GATEWAY")
public interface MSGatewayPatientService {

    /**
     * Retrieves the list of patients.
     *
     * @return the list of patients
     */
    @GetMapping(value = "/patients")
    List<PatientBean> patientsList();

    /**
     * Retrieves information about a specific patient.
     *
     * @param id the ID of the patient
     * @return information about the specified patient
     */
    @GetMapping(value = "/patients/{id}")
    PatientBean patientInfos(@PathVariable Integer id);

    /**
     * Creates a new patient.
     *
     * @param newPatientBean the new patient to be created
     * @return the created patient
     */
    @PostMapping(value = "/patients")
    NewPatientBean createPatient(@Valid NewPatientBean newPatientBean);

    /**
     * Updates information about a specific patient.
     *
     * @param id                  the ID of the patient to be updated
     * @param patientToUpdateBean the updated patient information
     * @return the updated patient information
     */
    @PutMapping("/patients/{id}")
    PatientBean updatePatient(@PathVariable String id, @Valid PatientBean patientToUpdateBean);
}
