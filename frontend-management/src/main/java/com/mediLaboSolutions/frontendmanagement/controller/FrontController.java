package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSBackendPatientManagement;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class FrontController {

    private final MSBackendPatientManagement msBackendPatientManagement;

    public FrontController(MSBackendPatientManagement msBackendPatientManagement) {
        this.msBackendPatientManagement = msBackendPatientManagement;
    }

    @RequestMapping("/")
    public String home(Model model) {

        List<PatientBean> patients = msBackendPatientManagement.patientsList();
        model.addAttribute("patients", patients);

        return "patients";
    }

    @RequestMapping("/patient/{id}")
    public String patientInfos(@PathVariable Integer id, Model model) {

        PatientBean patient = msBackendPatientManagement.patientInfos(id);
        patient.setPatientId(id);
        model.addAttribute("patient", patient);

        return "patient-details";
    }

    @RequestMapping("/create-patient")
    public String newPatient(Model model) {

        PatientBean newPatient = new PatientBean();
        model.addAttribute("newPatient", newPatient);

        return "create-patient";
    }

    @PostMapping("/create-patient")
    public String createPatient(@Valid PatientBean patientBean, Model model) {
        PatientBean patient = msBackendPatientManagement.createPatient(patientBean);
        log.info("id : {}", patient.getPatientId());
        model.addAttribute("patient", patient);

        return "patient-details";
    }

    @PostMapping("/patient")
    public String editPatient(@Valid PatientBean updatePatient, Model model) {


        PatientBean patient = msBackendPatientManagement.updatePatient(updatePatient);
        model.addAttribute("patient", patient);

        return patientInfos(updatePatient.getPatientId(), model);
    }

}
