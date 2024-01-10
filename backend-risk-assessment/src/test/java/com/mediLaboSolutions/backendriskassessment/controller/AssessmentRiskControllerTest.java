package com.mediLaboSolutions.backendriskassessment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.mediLaboSolutions.backendriskassessment.constants.TermsRiskAssessmentResults.NONE;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AssessmentRiskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRiskAssessmentResult() throws Exception {//TODO fix feign
        //Given


        //When we initiate the request
        mockMvc.perform(get("/risk-assessment/1"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(NONE));
    }
}