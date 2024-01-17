package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.NoteBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.RiskAssessmentBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGatewayNoteService;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGatewayPatientService;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGatewayRiskAssessmentService;
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

    private final MSGatewayPatientService msGatewayPatientService;

    private final MSGatewayNoteService msGatewayNoteService;

    private final MSGatewayRiskAssessmentService msGatewayRiskAssessmentService;

    public PatientController(MSGatewayPatientService msGatewayPatientService, MSGatewayNoteService msGatewayNoteService, MSGatewayRiskAssessmentService msGatewayRiskAssessmentService) {
        this.msGatewayPatientService = msGatewayPatientService;
        this.msGatewayNoteService = msGatewayNoteService;
        this.msGatewayRiskAssessmentService = msGatewayRiskAssessmentService;
    }

    /**
     * Handles GET requests to retrieve the list of patients.
     *
     * @param model the Spring MVC model
     * @return the logical view name for displaying the patient list
     */
    @GetMapping("/patients")
    public String patientList(Model model) {
        List<PatientBean> patients = msGatewayPatientService.patientsList();
        model.addAttribute("patients", patients);
        return "patientList";
    }

    /**
     * Handles GET requests to retrieve patient details by ID.
     *
     * @param id    the ID of the patient
     * @param model the Spring MVC model
     * @return the logical view name for displaying patient details
     */
    @GetMapping("/patients/{id}")
    public String patientInfos(@PathVariable Integer id, Model model) {
        final PatientBean patient = msGatewayPatientService.patientInfos(id);
        final List<NoteBean> notes = msGatewayNoteService.getPatientNotes(String.valueOf(id));
        final RiskAssessmentBean riskAssessment = msGatewayRiskAssessmentService.getRiskAssessmentResult(id);

        model.addAttribute("patient", patient);
        model.addAttribute("notes", notes);
        model.addAttribute("riskAssessment", riskAssessment);
        model.addAttribute("lineSeparator", System.lineSeparator());
        model.addAttribute("newNote", new NoteBean());

        return "patient-details";
    }

    /**
     * Handles GET requests to display the form for creating a new patient.
     *
     * @param model the Spring MVC model
     * @return the logical view name for the create-patient form
     */
    @GetMapping("/patients/create")
    public String newPatient(Model model) {
        model.addAttribute("newPatient", new NewPatientBean());
        return "create-patient";
    }

    /**
     * Handles POST requests to create a new patient.
     *
     * @param newPatientBean the data for the new patient
     * @return the logical view name for redirecting to the patient list
     */
    @PostMapping("/patients/create")
    public String createNewPatient(@Valid NewPatientBean newPatientBean) {
        msGatewayPatientService.createPatient(newPatientBean);
        log.info("Front --> Ask to create patient : {} + {}", newPatientBean.getFirstname(), newPatientBean.getLastname());
        return "redirect:/patients";
    }

    /**
     * Handles POST requests to update an existing patient.
     *
     * @param id                   the ID of the patient to be updated
     * @param patientToUpdateBean the updated data for the patient
     * @param model                the Spring MVC model
     * @return the logical view name for redirecting to the updated patient details
     */
    @PostMapping("/patients/{id}")
    public String editPatient(@PathVariable Integer id, @Valid PatientBean patientToUpdateBean, Model model) {
        log.info("Front --> Ask to update patient : {} + {}", patientToUpdateBean.getFirstname(), patientToUpdateBean.getLastname());
        final PatientBean updatedPatient = msGatewayPatientService.updatePatient(String.valueOf(id), patientToUpdateBean);
        model.addAttribute("patient", updatedPatient);
        return "redirect:/patients/{id}";
    }
}
