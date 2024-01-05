package com.mediLaboSolutions.frontendmanagement.proxies;

import org.springframework.stereotype.Component;

@Component
public class AuthService {

    private String token;

    public void saveToken(String token) {
        if (token.isBlank()) {
            throw new RuntimeException("no token found");
        }
        this.token = token;
    }

    public String getAuthorizationToken() {
        return token;
    }

}
