package com.mediLaboSolutions.backendnote.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@Transactional // TODO err transactional
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Try to perform method Get on /notes/{patientId}")
    @Test
    void getAllPatientNotes() throws Exception {
        //Given


        //When we initiate the request
        mockMvc.perform(get("/notes/2"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Le patient dÃ©clare avoir fait une rÃ©action " +
                        "aux mÃ©dicaments au cours des 3 derniers mois\\r\\nIl remarque Ã©galement que " +
                        "son audition continue d'Ãªtre anormale")));
    }

    @DisplayName("Try to perform method Get on /notes")
    @Test
    void addNote() throws Exception {
        //Given initial DTO
        NoteDTO noteDTO = new NoteDTO("2", "contenu de test!!");
        String content = noteDTO.getContent();

        //When we initiate the request
        mockMvc.perform(post("/notes")
                        .content(new ObjectMapper().writeValueAsString(noteDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))

                //Then we verify is all works correctly
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(content)));
    }
}