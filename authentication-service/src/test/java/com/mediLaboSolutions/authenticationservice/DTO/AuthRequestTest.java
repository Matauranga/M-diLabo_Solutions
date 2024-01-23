package com.mediLaboSolutions.authenticationservice.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthRequestTest {

    @Test
    void testConstructorsAndGettersSetters() {
        String username = "testUser";
        String password = "testPassword";
        String username2 = "testUserTest";
        String password2 = "testPasswordTest";


        AuthRequest authRequest = new AuthRequest();

        assertThat(authRequest).isNotNull();


        authRequest = new AuthRequest(username, password);

        assertEquals(username, authRequest.getUsername());
        assertEquals(password, authRequest.getPassword());


        authRequest.setUsername(username2);
        authRequest.setPassword(password2);

        assertEquals(username2, authRequest.getUsername());
        assertEquals(password2, authRequest.getPassword());
    }
}