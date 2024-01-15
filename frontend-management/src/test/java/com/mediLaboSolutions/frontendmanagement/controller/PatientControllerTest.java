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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTest {

    @Mock
    MSGateWay msGateWay; //Todo frank

    @InjectMocks
    PatientController patientController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
    }

    @Test
    void patientListPage() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(get("/patients"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(view().name("patientList"));

    }

    @Test
    void patientInfosPage() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(get("/patients/1"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(view().name("patient-details"));
    }

    @Test
    void newPatientPage() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(get("/patients/create"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(view().name("create-patient"));
    }

    @Test
    void createNewPatient() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(post("/patients/create"))

                //Then we verify is all works correctly
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("patientList"));
    }

    @Test
    void editPatient() throws Exception {
        //Given

        //When we initiate the request
        mockMvc.perform(post("/patients/1"))

                //Then we verify is all works correctly
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("patient-details"));
    }
}