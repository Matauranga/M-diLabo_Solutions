package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.DTO.AuthRequest;
import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientToUpdateBean;
import com.mediLaboSolutions.frontendmanagement.proxies.AuthService;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGateWay;
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

    private final MSGateWay msGateWay;
    private final AuthService authService;

    public FrontController(MSGateWay msGateWay, AuthService authService) {
        this.msGateWay = msGateWay;
        this.authService = authService;
    }

    @GetMapping("/patients")
    public String home(Model model) {

        List<PatientBean> patients = msGateWay.patientsList();
        model.addAttribute("patients", patients);

        return "patients";
    }

    @GetMapping("/patients/{id}")
    public String patientInfos(@PathVariable Integer id, Model model) {

        final PatientBean patient = msGateWay.patientInfos(id);
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

        msGateWay.createPatient(newPatientBean);
        log.info("Front --> Ask to create patient : {} + {}", newPatientBean.getFirstname(), newPatientBean.getLastname());

        return home(model);
    }

    @PostMapping("/patients/{id}")
    public String editPatient(@PathVariable Integer id, @Valid PatientToUpdateBean patientToUpdateBean, Model model) {

        log.info("Front --> Ask to update patient : {} + {}", patientToUpdateBean.getFirstname(), patientToUpdateBean.getLastname());
        final PatientToUpdateBean updatedPatient = msGateWay.updatePatient(String.valueOf(id), patientToUpdateBean);
        model.addAttribute("patient", updatedPatient);

        return patientInfos(id, model);
    }

    @GetMapping({"/", "/signin"})
    public String login(Model model) {
        model.addAttribute("authRequest", new AuthRequest());

        return "login";
    }

    @PostMapping("/signin")
    public String signin(AuthRequest authRequest, Model model) {
        try {
            final String token = msGateWay.login(authRequest);
            authService.saveToken(token);
            return home(model);

        } catch (Exception e) {
            log.error(e.getMessage());

            return login(model); //todo gerer err
        }
    }

}
