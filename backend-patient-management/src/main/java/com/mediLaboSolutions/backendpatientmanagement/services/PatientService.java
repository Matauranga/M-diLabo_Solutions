package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.models.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientService {

    List<Patient> getAllPatients();

    Optional<Patient> getPersonById(UUID id);

    Optional<Patient> getPatientByFirstAndLastName(String firstName, String lastName);

    Patient savePerson(Patient patientToCreate);

    void updatePatient(UUID id, Patient patient);

    void deletePatient(UUID id);

}
