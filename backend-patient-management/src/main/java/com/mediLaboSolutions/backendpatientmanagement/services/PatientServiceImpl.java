package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.NewPatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.exceptions.PatientNotFoundException;
import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
import com.mediLaboSolutions.backendpatientmanagement.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }

    /**
     * Retrieves a list of all patients.
     *
     * @return a list of PatientDTO representing all patients
     */
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientDTO::new)
                .toList();
    }

    /**
     * Retrieves a patient by their ID.
     *
     * @param patientId the ID of the patient to retrieve
     * @return the PatientDTO representing the patient
     * @throws PatientNotFoundException if the patient with the given ID is not found
     */
    public PatientDTO getPatientById(Integer patientId) {
        return new PatientDTO(patientRepository.findById(patientId).orElseThrow());
    }

    /**
     * Saves a new patient.
     *
     * @param newPatientDTO the NewPatientDTO containing information about the new patient
     */
    public void saveNewPatient(NewPatientDTO newPatientDTO) {
        Patient patientToCreate = new Patient();
        patientToCreate.setFirstname(newPatientDTO.getFirstname());
        patientToCreate.setLastname(newPatientDTO.getLastname());
        patientToCreate.setBirthdate(newPatientDTO.getBirthdate());
        patientToCreate.setGender(newPatientDTO.getGender());
        patientToCreate.setAddress(newPatientDTO.getAddress());
        patientToCreate.setPhonenumber(newPatientDTO.getPhonenumber());

        patientRepository.save(patientToCreate);
    }

    /**
     * Updates an existing patient.
     *
     * @param patientToUpdateDTO the PatientDTO containing updated information about the patient
     * @throws PatientNotFoundException if the patient to update is not found
     */
    public void updatePatient(PatientDTO patientToUpdateDTO) {
        if (!patientRepository.existsById(patientToUpdateDTO.getPatientId())) {
            throw new PatientNotFoundException("Patient doesn't exist");
        }

        Patient updatedPatient = patientRepository.findById(patientToUpdateDTO.getPatientId())
                .orElseThrow()
                .update(patientToUpdateDTO);

        patientRepository.save(updatedPatient);
    }
}
