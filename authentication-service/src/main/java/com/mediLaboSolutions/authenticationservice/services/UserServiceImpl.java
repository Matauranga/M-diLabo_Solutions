//package com.mediLaboSolutions.userservice.services;
//
//import com.mediLaboSolutions.userservice.exceptions.UserNotFoundException;
//import com.mediLaboSolutions.userservice.models.UserCredential;
//import com.mediLaboSolutions.userservice.repositories.UserCredentialRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserCredentialRepository userCredentialRepository;
//
//    public UserServiceImpl(UserCredentialRepository userCredentialRepository) {
//        this.userCredentialRepository = userCredentialRepository;
//    }
//
//    @Override
//    public UserCredential getUserByEmail(String email) {
//        return Optional.ofNullable(userCredentialRepository.getUserByEmail(email))
//                .orElseThrow(() -> new UserNotFoundException("UserCredential not found"));
//    }
//}
