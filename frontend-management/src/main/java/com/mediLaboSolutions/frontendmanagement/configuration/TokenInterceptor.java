package com.mediLaboSolutions.frontendmanagement.configuration;

import com.mediLaboSolutions.frontendmanagement.proxies.AuthService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;


@Component
public class TokenInterceptor implements RequestInterceptor {

    @Autowired
    private AuthService authService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        var token = authService.getAuthorizationToken();
        if (token != null) {
            requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        }
    }
}
