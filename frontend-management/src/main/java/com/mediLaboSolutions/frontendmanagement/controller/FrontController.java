package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSBackendPatientManagement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/patient/{id}")
    public String patientInfos(@PathVariable Integer id, Model model) {

        PatientBean patient = msBackendPatientManagement.patientInfos(id);
        model.addAttribute("patient", patient);

        return "patient-details";
    }

}
