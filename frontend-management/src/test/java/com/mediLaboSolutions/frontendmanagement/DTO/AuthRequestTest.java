package com.mediLaboSolutions.frontendmanagement.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AuthRequestTest {

    @Test
    public void testConstructorsAndGettersSetters() {
        AuthRequest authRequest = new AuthRequest();
        assertThat(authRequest).isNotNull();

        authRequest = new AuthRequest("gio", "123");
        assertThat(authRequest.getUsername()).isEqualTo("gio");
        assertThat(authRequest.getPassword()).isEqualTo("123");

        authRequest.setUsername("newGio");
        authRequest.setPassword("456");
        assertThat(authRequest.getUsername()).isEqualTo("newGio");
        assertThat(authRequest.getPassword()).isEqualTo("456");
    }

}