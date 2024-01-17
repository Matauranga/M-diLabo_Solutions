package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.beans.NoteBean;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Feign client interface for communicating with the Note Service through the Gateway.
 */
@FeignClient(name = "MS-GATEWAY-NOTE",url = "${ms.gateway.url}")
public interface MSGatewayNoteService {

    /**
     * Retrieves the list of notes for a specific patient.
     *
     * @param id the ID of the patient
     * @return the list of notes for the specified patient
     */
    @GetMapping(value = "/notes/{id}")
    List<NoteBean> getPatientNotes(@PathVariable String id);

    /**
     * Creates a new note.
     *
     * @param noteBean the note to be created
     * @return the created note
     */
    @PostMapping(value = "/notes")
    NoteBean createNewNote(@Valid NoteBean noteBean);
}