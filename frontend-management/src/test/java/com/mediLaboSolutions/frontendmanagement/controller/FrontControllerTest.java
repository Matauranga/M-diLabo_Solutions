package com.mediLaboSolutions.frontendmanagement.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FrontControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void home() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(get("/"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Patients List")));
    }

    @Test
    void patientInfos() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(get("/patients/1"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Fiche Patient")));
    }

    @Test
    void newPatient() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(get("/patients/create"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Create New Patient")));
    }

    @Test
    void createNewPatient() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(post("/patients/create"))

                //Then we verify is all works correctly
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("Patients List")));
    }

    @Test
    void editPatient() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(post("/patients/1"))

                //Then we verify is all works correctly
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString("Fiche Patient")));
    }
}