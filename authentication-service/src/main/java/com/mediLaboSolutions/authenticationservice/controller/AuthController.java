package com.mediLaboSolutions.authenticationservice.controller;


import com.mediLaboSolutions.authenticationservice.DTO.AuthRequest;
import com.mediLaboSolutions.authenticationservice.models.UserCredential;
import com.mediLaboSolutions.authenticationservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/auth")
public class AuthController { //todo enlever register et validate
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> getToken(@RequestBody AuthRequest authRequest) {
        var authentication = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);

        if (authenticate.isAuthenticated()) {
            return ResponseEntity.ok(service.generateToken(authRequest.getUsername()));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
