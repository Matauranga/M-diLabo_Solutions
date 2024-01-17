package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.NewPatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;

import java.util.List;

public interface PatientService {
    /**
     * Retrieves a list of all patients.
     *
     * @return a list of PatientDTO representing all patients
     */
    List<PatientDTO> getAllPatients();

    /**
     * Retrieves a patient by their ID.
     *
     * @param patientId the ID of the patient to retrieve
     * @return the PatientDTO representing the patient
     */
    PatientDTO getPatientById(Integer patientId);

    /**
     * Saves a new patient.
     *
     * @param newPatientDTO the NewPatientDTO containing information about the new patient
     */
    void saveNewPatient(NewPatientDTO newPatientDTO);

    /**
     * Updates an existing patient.
     *
     * @param patientToUpdateDTO the PatientDTO containing updated information about the patient
     */
    void updatePatient(PatientDTO patientToUpdateDTO);
}
