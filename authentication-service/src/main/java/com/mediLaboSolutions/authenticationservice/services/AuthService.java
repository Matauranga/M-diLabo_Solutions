package com.mediLaboSolutions.authenticationservice.services;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

//    @Autowired
//    private UserCredentialRepository repository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public AuthService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

//    public String saveUser(UserCredential credential) {
//        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
//        repository.save(credential);
//        return "user added to the system";
//    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

//    public void validateToken(String token) {
//        jwtService.validateToken(token);
//    }


}