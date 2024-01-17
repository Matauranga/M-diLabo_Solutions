package com.mediLaboSolutions.backendriskassessment.proxies;

import com.mediLaboSolutions.backendriskassessment.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Feign client interface for interacting with the MS-BACKEND-NOTE microservice.
 */
@FeignClient(name = "MS-BACKEND-NOTE")
public interface MSBackendNote {

    /**
     * Retrieves notes of a specific patient from the MS-BACKEND-NOTE microservice.
     *
     * @param id the ID of the patient whose notes are to be retrieved
     * @return a list of NoteBean representing the patient's notes
     */
    @GetMapping(value = "/notes/{id}")
    List<NoteBean> getPatientNotes(@PathVariable String id);
}
