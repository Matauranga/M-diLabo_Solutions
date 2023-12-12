package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientToUpdateBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSBackendPatientManagement;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class FrontController {

    private final MSBackendPatientManagement msBackendPatientManagement;

    public FrontController(MSBackendPatientManagement msBackendPatientManagement) {
        this.msBackendPatientManagement = msBackendPatientManagement;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<PatientBean> patients = msBackendPatientManagement.patientsList();
        model.addAttribute("patients", patients);

        return "patients";
    }

    @GetMapping("/patients/{id}")
    public String patientInfos(@PathVariable Integer id, Model model) {

        final PatientBean patient = msBackendPatientManagement.patientInfos(id);
        model.addAttribute("patient", patient);

        return "patient-details";
    }

    @GetMapping("/patients/create")
    public String newPatient(Model model) {

        model.addAttribute("newPatient", new NewPatientBean());

        return "create-patient";
    }

    @PostMapping("/patients/create")
    public String createNewPatient(@Valid NewPatientBean newPatientBean, Model model) {

        msBackendPatientManagement.createPatient(newPatientBean);
        log.info("Front --> Ask to create patient : {} + {}", newPatientBean.getFirstname(), newPatientBean.getLastname());

        return home(model);
    }

    @PostMapping("/patients/{id}")
    public String editPatient(@PathVariable Integer id, @Valid PatientToUpdateBean patientToUpdateBean, Model model) {

        log.info("Front --> Ask to update patient : {} + {}", patientToUpdateBean.getFirstname(), patientToUpdateBean.getLastname());
        final PatientToUpdateBean updatedPatient = msBackendPatientManagement.updatePatient(String.valueOf(id), patientToUpdateBean);
        model.addAttribute("patient", updatedPatient);

        return patientInfos(id, model);
    }

}
