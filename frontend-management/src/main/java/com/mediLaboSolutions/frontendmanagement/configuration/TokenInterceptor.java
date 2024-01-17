package com.mediLaboSolutions.frontendmanagement.configuration;

import com.mediLaboSolutions.frontendmanagement.proxies.AuthService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;


@Component
public class TokenInterceptor implements RequestInterceptor {

    private final AuthService authService;

    public TokenInterceptor(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Applies the interceptor logic to add the Authorization token to the request header.
     *
     * @param requestTemplate the template representing the outgoing Feign request
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        var token = authService.getAuthorizationToken();
        if (token != null) {
            requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        }
    }
}
