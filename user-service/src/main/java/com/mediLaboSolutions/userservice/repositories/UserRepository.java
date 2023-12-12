package com.mediLaboSolutions.userservice.repositories;

import com.mediLaboSolutions.userservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Users getUserByEmail(String email);
}
