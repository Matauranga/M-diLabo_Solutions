package com.mediLaboSolutions.backendpatientmanagement.repositories;

import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    Patient findByFirstnameAndLastname(String firstname, String lastname);

    Boolean existsByFirstnameAndLastname(String firstname, String lastname);

}
