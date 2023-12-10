package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "patient", url = "localhost:9001")
public interface MSBackendPatientManagement {

    @GetMapping(value = "/patients")
    List<PatientBean> patientsList();

    @GetMapping(value = "/patient")
    PatientBean patientInfos(@RequestParam Integer id);

    @PostMapping(value = "/patient")
    PatientBean createPatient(@Valid @RequestBody PatientBean patientBean);

    @PutMapping("/patient")
    PatientBean updatePatient(@Valid @RequestBody PatientBean patientBean);

}
