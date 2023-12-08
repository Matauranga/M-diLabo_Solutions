package com.mediLaboSolutions.backendpatientmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.utils.PatientFaker;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Try to perform method Get on /patients")
    @Test
    void patientsList() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(get("/patients"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("TestBorderline")));
    }

    @DisplayName("Try to perform method Get on /patient")
    @Test
    void patientInfos() throws Exception {
        //Given


        //When we initiate the request
        mockMvc.perform(get("/patient?id=2"))
                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("TestBorderline")));
    }

    @DisplayName("Try to perform method Post on /patient")
    @Test
    void createPatient() throws Exception {
        //Given
        PatientDTO patientDTO = new PatientDTO(PatientFaker.generate());
        patientDTO.setBirthdate(null);
        String lastname = patientDTO.getLastname();

        //When we initiate the request
        mockMvc.perform(post("/patient")
                        .content(new ObjectMapper().writeValueAsString(patientDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //Then we verify is all works correctly
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(lastname)));
    }

    @DisplayName("Try to perform method Put on /patient")
    @Test
    void updatePatient() throws Exception {
        //Given
        PatientDTO patientDTO = new PatientDTO(1, "Test", "TestNone", null, "F", "Toulon", "999-999-9999");


        //When we initiate the request
        mockMvc.perform(put("/patient")
                        .content(new ObjectMapper().writeValueAsString(patientDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Toulon")));
    }

    @DisplayName("Try to perform method Delete on /patient")
    @Test
    void deletePatient() throws Exception {
        //Given
        PatientDTO patientDTO = new PatientDTO(202, "Test", "TestNone", null, null, null, null);


        //When we initiate the request
        mockMvc.perform(delete("/patient")
                        .content(new ObjectMapper().writeValueAsString(patientDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //Then we verify is all works correctly
                .andExpect(status().isOk());
    }
}