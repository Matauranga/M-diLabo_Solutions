package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.NoteBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGatewayNoteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class NoteController {

    private final MSGatewayNoteService msGatewayNoteService;

    public NoteController(MSGatewayNoteService msGatewayNoteService) {
        this.msGatewayNoteService = msGatewayNoteService;
    }

    /**
     * Handles POST requests for creating a new note for a specific patient.
     *
     * @param id       the patient ID for whom the note is created
     * @param noteBean the data for the new note
     * @return the logical view name for redirecting to the patient details page
     */
    @PostMapping("/patients/{id}/notes")
    public String addNewNote(@PathVariable Integer id, @Valid NoteBean noteBean) {
        log.info("Front --> Ask to create note");
        noteBean.setPatientId(String.valueOf(id));
        msGatewayNoteService.createNewNote(noteBean);
        return "redirect:/patients/{id}";
    }
}
