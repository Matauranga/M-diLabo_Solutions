package com.mediLaboSolutions.authenticationservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mediLaboSolutions.authenticationservice.DTO.AuthRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTokenSuccess() throws Exception {
        //Given
        AuthRequest authRequest = new AuthRequest("admin", "admin");
        String requestJson = getRequestJson(authRequest);

        //When we initiate the request
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                //Then we verify is all works correctly
                .andExpect(status().isOk());
    }

    @Test
    void getTokenFailed() throws Exception {
        //Given
        AuthRequest authRequest = new AuthRequest("jjj", "admin");
        String requestJson = getRequestJson(authRequest);

        //When we initiate the request
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                //Then we verify is all works correctly
                .andExpect(status().isUnauthorized());
    }

    private static String getRequestJson(AuthRequest authRequest) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(authRequest);
    }
}