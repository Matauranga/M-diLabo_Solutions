package com.mediLaboSolutions.backendriskassessment.controller;

import com.mediLaboSolutions.backendriskassessment.DTO.AssessmentResultDTO;
import com.mediLaboSolutions.backendriskassessment.services.AssessmentRiskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.mediLaboSolutions.backendriskassessment.constants.TermsRiskAssessmentResults.NONE;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AssessmentRiskControllerTest {

    @Mock
    AssessmentRiskService assessmentRiskService;

    @InjectMocks
    AssessmentRiskController assessmentRiskController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(assessmentRiskController).build();
    }

    @Test
    void getRiskAssessmentResult() throws Exception {
        //Given
        when(assessmentRiskService.getRiskAssessmentResult(any())).thenReturn(new AssessmentResultDTO(NONE));

        //When we initiate the request
        mockMvc.perform(get("/risk-assessment/1"))

                //Then we verify is all works correctly
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("None")));
    }

}