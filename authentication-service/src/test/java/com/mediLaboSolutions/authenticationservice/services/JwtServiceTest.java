package com.mediLaboSolutions.authenticationservice.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class JwtServiceTest {

    @Autowired
    JwtService jwtService;

    @Test
    void generateToken() {
        //Given

        //When
        String response = jwtService.generateToken("salut");

        //Then
        assertThat(response).isNotEmpty();
    }
}