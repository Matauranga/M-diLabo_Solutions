package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.models.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientService {

    List<PatientDTO> getAllPatients();

    Optional<Patient> getPatientById(UUID id);

    PatientDTO getPatientByFirstAndLastName(String firstName, String lastName);

    Patient savePatient(Patient patientToCreate);

    void saveNewPatient(PatientDTO patientDTO);

    void updatePatient(PatientDTO UpdatedPatient);

    void deletePatient(PatientDTO patientDTO);

}
