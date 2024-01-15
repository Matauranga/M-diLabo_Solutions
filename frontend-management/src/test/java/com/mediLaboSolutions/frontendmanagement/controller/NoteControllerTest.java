package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.proxies.MSGateWay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTest {

    @Mock
    MSGateWay msGateWay;

    @Mock
    PatientController patientController;

    @InjectMocks
    NoteController noteController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
    }

    @Test
    void addNewNote() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(post("/patients/1/notes"))

                //Then we verify is all works correctly
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("patients/1/notes")/*.name("patient-details")*/);//TODO frank redirection

    }
}