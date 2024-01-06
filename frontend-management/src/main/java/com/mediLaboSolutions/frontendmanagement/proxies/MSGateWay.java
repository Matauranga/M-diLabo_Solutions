package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.DTO.AuthRequest;
import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.NoteBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "MS-GATEWAY")
public interface MSGateWay {

    /**
     *  ALL ENDPOINT --> BACKEND PATIENT MANAGEMENT
     */

    @GetMapping(value = "/patients")
    List<PatientBean> patientsList();

    @GetMapping(value = "/patients/{id}")
    PatientBean patientInfos(@PathVariable Integer id);

    @PostMapping(value = "/patients")
    NewPatientBean createPatient(@Valid NewPatientBean newPatientBean);

    @PutMapping("/patients/{id}")
    PatientBean updatePatient(@PathVariable String id, @Valid PatientBean patientToUpdateBean);


    /**
     *  ALL ENDPOINT --> BACKEND NOTE
     */


    @GetMapping(value = "/notes/{id}")
    List<NoteBean> getPatientNotes(@PathVariable String id);

    @PostMapping(value = "/notes")
    NoteBean createNewNote(@Valid NoteBean noteBean);


    /**
     *  ALL ENDPOINT --> AUTHENTICATION SERVICE
     */


    @PostMapping(value = "/auth/login")
    String login(@Valid AuthRequest authRequest);

//TODO gerer le logout
//    @PostMapping(value = "/auth/logout")
//    String logout();

}
