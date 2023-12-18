package com.mediLaboSolutions.userservice.services;

import com.mediLaboSolutions.userservice.exceptions.UserNotFoundException;
import com.mediLaboSolutions.userservice.models.Users;
import com.mediLaboSolutions.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.getUserByEmail(email))
                .orElseThrow(() -> new UserNotFoundException("Users not found"));
    }
}
