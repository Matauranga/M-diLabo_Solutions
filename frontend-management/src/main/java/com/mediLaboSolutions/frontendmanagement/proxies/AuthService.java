package com.mediLaboSolutions.frontendmanagement.proxies;

import org.springframework.stereotype.Component;

@Component
public class AuthService {

    private String token;

    /**
     * Saves the authentication token.
     *
     * @param token the authentication token to be saved
     * @throws RuntimeException if the provided token is blank
     */
    public void saveToken(String token) {
        if (token.isBlank()) {
            throw new RuntimeException("No token found");
        }
        this.token = token;
    }

    /**
     * Logs out the user by clearing the authentication token.
     */
    public void logout() {
        this.token = null;
    }

    /**
     * Retrieves the stored authentication token.
     *
     * @return the authentication token
     */
    public String getAuthorizationToken() {
        return token;
    }
}
