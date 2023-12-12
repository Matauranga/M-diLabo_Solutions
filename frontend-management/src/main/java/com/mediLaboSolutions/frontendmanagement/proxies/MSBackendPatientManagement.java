package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientToUpdateBean;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "MS-GATEWAY")
public interface MSBackendPatientManagement {

    @GetMapping(value = "/patients")
    List<PatientBean> patientsList();

    @GetMapping(value = "/patients/{id}")
    PatientBean patientInfos(@PathVariable Integer id);

    @PostMapping(value = "/patients")
    NewPatientBean createPatient(@Valid NewPatientBean newPatientBean);

    @PutMapping("/patients/{id}")
    PatientToUpdateBean updatePatient(@PathVariable String id, @Valid PatientToUpdateBean patientToUpdateBean);
}
