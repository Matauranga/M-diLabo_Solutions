package com.mediLaboSolutions.frontendmanagement.configuration;

import com.mediLaboSolutions.frontendmanagement.proxies.AuthService;
import feign.RequestTemplate;
import jakarta.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class TokenInterceptorTest {

    @Mock
    AuthService authService;
    @Mock
    RequestTemplate requestTemplate;

    @Test
    public void testApply() {
        //Given
        String token = "123";

        //When
        when(authService.getAuthorizationToken()).thenReturn(token);
        TokenInterceptor tokenInterceptor = new TokenInterceptor(authService);
        tokenInterceptor.apply(requestTemplate);

        //Then
        verify(authService, times(1)).getAuthorizationToken();
        verify(requestTemplate).header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }
}