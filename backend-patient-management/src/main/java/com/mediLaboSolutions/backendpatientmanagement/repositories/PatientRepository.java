package com.mediLaboSolutions.backendpatientmanagement.repositories;

import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
