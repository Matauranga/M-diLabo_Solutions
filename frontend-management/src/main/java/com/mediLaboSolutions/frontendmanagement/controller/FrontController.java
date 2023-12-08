package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSBackendPatientManagement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @RequestMapping("/patient-details")
    public String patientInfos(@RequestParam String firstname,
                               @RequestParam String lastname, Model model) {

        PatientBean patient = msBackendPatientManagement.patientInfos(firstname, lastname);
        model.addAttribute("patient", patient);

        return "patient-details";
    }

}
