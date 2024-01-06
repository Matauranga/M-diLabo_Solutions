package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.DTO.AuthRequest;
import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.NoteBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientToUpdateBean;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "MS-GATEWAY")
public interface MSGateWay {

    @GetMapping(value = "/patients")
    List<PatientBean> patientsList();

    @GetMapping(value = "/patients/{id}")
    PatientBean patientInfos(@PathVariable Integer id);

    @PostMapping(value = "/patients")
    NewPatientBean createPatient(@Valid NewPatientBean newPatientBean);

    @PutMapping("/patients/{id}")
    PatientToUpdateBean updatePatient(@PathVariable String id, @Valid PatientToUpdateBean patientToUpdateBean);

    @GetMapping(value = "/notes/{id}")
    List<NoteBean> getPatientNotes(@PathVariable String id);

    @PostMapping(value = "/auth/login")
    String login(@Valid AuthRequest authRequest);

//TODO gerer le logout
//    @PostMapping(value = "/auth/logout")
//    String logout();

}
