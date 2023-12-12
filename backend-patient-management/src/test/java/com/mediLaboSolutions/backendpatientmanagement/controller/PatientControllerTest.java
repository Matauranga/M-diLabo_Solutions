package com.mediLaboSolutions.backendpatientmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediLaboSolutions.backendpatientmanagement.DTO.NewPatientDTO;
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
                .andExpect(content().string(containsString("TestNone")))
                .andExpect(content().string(containsString("TestBorderline")))
                .andExpect(content().string(containsString("TestInDanger")))
                .andExpect(content().string(containsString("TestEarlyOnset")));
    }

    @DisplayName("Try to perform method Get on /patients/{id}")
    @Test
    void patientInfos() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(get("/patients/2"))
                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("TestBorderline")))
                .andExpect(content().string(containsString("2 High St")));
    }

    @DisplayName("Try to perform method Post on /patients, patient creation")
    @Test
    void createPatient() throws Exception {
        //Given
        NewPatientDTO newPatientDTO = PatientFaker.generateNewPatientDTO();
        String lastname = newPatientDTO.getLastname();

        //When we initiate the request
        mockMvc.perform(post("/patients")
                        .content(new ObjectMapper().writeValueAsString(newPatientDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(lastname)));
    }

    @DisplayName("Try to perform method Put on /patients/{id}")
    @Test
    void updatePatient() throws Exception {
        //Given
        PatientDTO patientDTO = new PatientDTO(1, "Test", "TestNone", null, "F", "Toulon", "999-999-9999");


        //When we initiate the request
        mockMvc.perform(put("/patients/1")
                        .content(new ObjectMapper().writeValueAsString(patientDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Toulon")));
    }
}