package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.NoteBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.RiskAssessmentBean;
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
public class PatientController {

    private final MSGateWay msGateWay;

    public PatientController(MSGateWay msGateWay) {
        this.msGateWay = msGateWay;
    }

    @GetMapping("/patients")
    public String patientList(Model model) {

        List<PatientBean> patients = msGateWay.patientsList();
        model.addAttribute("patients", patients);

        return "patientList";
    }

    @GetMapping("/patients/{id}")
    public String patientInfos(@PathVariable Integer id, Model model) {

        final PatientBean patient = msGateWay.patientInfos(id);
        final List<NoteBean> notes = msGateWay.getPatientNotes(String.valueOf(id));
        final RiskAssessmentBean riskAssessment = msGateWay.getRiskAssessmentResult(id);

        model.addAttribute("patient", patient);
        model.addAttribute("notes", notes);
        model.addAttribute("riskAssessment", riskAssessment);
        model.addAttribute("lineSeparator", System.lineSeparator());
        model.addAttribute("newNote", new NoteBean());

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

        return patientList(model);
    }

    @PostMapping("/patients/{id}")
    public String editPatient(@PathVariable Integer id, @Valid PatientBean patientToUpdateBean, Model model) {

        log.info("Front --> Ask to update patient : {} + {}", patientToUpdateBean.getFirstname(), patientToUpdateBean.getLastname());
        final PatientBean updatedPatient = msGateWay.updatePatient(String.valueOf(id), patientToUpdateBean);
        model.addAttribute("patient", updatedPatient);

        return patientInfos(id, model);
    }

}
