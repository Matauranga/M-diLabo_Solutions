package com.mediLaboSolutions.userservice.services;

import com.mediLaboSolutions.userservice.models.Users;

public interface UserService {
    Users getUserByEmail(String email);
}
