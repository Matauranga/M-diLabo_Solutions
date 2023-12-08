package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "patient", url = "localhost:9001")
public interface MSBackendPatientManagement {

    @GetMapping(value = "/patients")
    List<PatientBean> patientsList();

    @GetMapping(value = "/patient")
    PatientBean patientInfos(@RequestParam Integer id);
}
