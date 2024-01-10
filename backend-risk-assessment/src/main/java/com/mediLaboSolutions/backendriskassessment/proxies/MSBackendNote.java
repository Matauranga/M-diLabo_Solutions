package com.mediLaboSolutions.backendriskassessment.proxies;

import com.mediLaboSolutions.backendriskassessment.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-BACKEND-NOTE")
public interface MSBackendNote {

    /**
     *  ALL ENDPOINT --> BACKEND NOTE
     */

    @GetMapping(value = "/notes/{id}")
    List<NoteBean> getPatientNotes(@PathVariable String id);

}
