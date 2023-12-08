package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.models.Patient;

import java.util.List;

public interface PatientService {

    List<PatientDTO> getAllPatients();

    PatientDTO getPatientById(Integer patientId);

    Patient savePatient(Patient patientToCreate);

    void saveNewPatient(PatientDTO patientDTO);

    void updatePatient(PatientDTO UpdatedPatient);

    void deletePatient(PatientDTO patientDTO);

}
