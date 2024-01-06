package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.NoteBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGateWay;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class NoteController {

    private final MSGateWay msGateWay;
    private final PatientController patientController;

    public NoteController(MSGateWay msGateWay, PatientController patientController) {
        this.msGateWay = msGateWay;
        this.patientController = patientController;
    }

    @PostMapping("/patients/{id}/notes")
    public String addNewNote(@PathVariable Integer id, @Valid NoteBean noteBean, Model model) {

        log.info("Front --> Ask to create note");
        noteBean.setPatientId(String.valueOf(id));
        msGateWay.createNewNote(noteBean);

        return patientController.patientInfos(id, model);
    }

}
