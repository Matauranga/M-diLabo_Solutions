package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.DTO.AuthRequest;
import com.mediLaboSolutions.frontendmanagement.proxies.AuthService;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGatewayAuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
class LoginControllerTest {

    @Mock
    Model model;
    @Mock
    MSGatewayAuthenticationService msGatewayAuthenticationService;
    @Mock
    AuthService authService;

    @InjectMocks
    LoginController loginController;

    @Test
    void login() {
        //Given

        //When
        String response = loginController.login(model);

        //Then
        assertEquals("login", response);
    }

    @Test
    void signinSuccess() {
        //Given
        AuthRequest authRequest = new AuthRequest("", "");

        //When
        when(msGatewayAuthenticationService.login(any())).thenReturn("123");
        doNothing().when(authService).saveToken(any());

        String response = loginController.signin(authRequest);

        //Then
        assertEquals("redirect:/patients", response);
    }

    @Test
    void signinFailed() {
        //Given
        AuthRequest authRequest = new AuthRequest("", "");

        //When
        doThrow(RuntimeException.class).when(authService).saveToken(any());
        String response = loginController.signin(authRequest);

        //Then
        assertEquals("redirect:/", response);
    }

    @Test
    void logout() {
        //Given

        //When
        String response = loginController.logout();

        //Then
        assertEquals("redirect:/", response);
    }
}