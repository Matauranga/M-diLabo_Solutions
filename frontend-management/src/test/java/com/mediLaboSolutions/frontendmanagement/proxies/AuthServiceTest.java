package com.mediLaboSolutions.frontendmanagement.proxies;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthServiceTest {
    @InjectMocks
    AuthService authService;

    @Test
    public void testSaveTokenSuccess() {
        //Given
        String token = "123";

        //When
        authService.saveToken(token);

        //Then
        assertEquals(token, authService.getAuthorizationToken());
    }

    @Test
    public void testSaveTokenFailed() {
        //Given
        String token = "";

        //When
        String response = assertThrows(RuntimeException.class, () -> authService.saveToken("")).getMessage();

        //Then
        assertNull(authService.getAuthorizationToken());
        assertEquals("no token found", response);
    }


    @Test
    public void testLogout() {
        //Given
        String token = "123";
        authService.saveToken(token);

        //When
        authService.logout();

        //Then
        assertNull(authService.getAuthorizationToken());
    }

}