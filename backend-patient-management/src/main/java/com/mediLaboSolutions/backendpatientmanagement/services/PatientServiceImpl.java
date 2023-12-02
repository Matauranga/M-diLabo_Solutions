package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.exceptions.PatientAlreadyExistsException;
import com.mediLaboSolutions.backendpatientmanagement.exceptions.PatientNotFoundException;
import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
import com.mediLaboSolutions.backendpatientmanagement.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientDTO::new)
                .toList();
    }

    public Optional<Patient> getPatientById(UUID id) {
        return patientRepository.findById(id);
    }

    public PatientDTO getPatientByFirstAndLastName(String firstName, String lastName) {
        return new PatientDTO(patientRepository.findByFirstnameAndLastname(firstName, lastName));
    }

    public Patient savePatient(Patient patientToCreate) {
        return patientRepository.save(patientToCreate);
    }

    public void saveNewPatient(PatientDTO patientDTO) {
        if (patientRepository.existsByFirstnameAndLastname(patientDTO.getFirstname(), patientDTO.getLastname())) {
            throw new PatientAlreadyExistsException("This patient already exist in data base.");
        }
        Patient patient = new Patient();
        patient.update(patientDTO);
        patientRepository.save(patient);
    }

    public void updatePatient(PatientDTO updatedPatientDto) {
        if (!patientRepository.existsByFirstnameAndLastname(updatedPatientDto.getFirstname(), updatedPatientDto.getLastname())) {
            throw new PatientNotFoundException("Patient doesn't exists");
        }

        Patient updatedPatient = patientRepository.findByFirstnameAndLastname(updatedPatientDto.getFirstname(), updatedPatientDto.getLastname())
                .update(updatedPatientDto);

        patientRepository.save(updatedPatient);
    }

    public void deletePatient(PatientDTO patientDTO) {

        patientRepository.deleteById(getIdFromName(patientDTO));
    }

    private UUID getIdFromName(PatientDTO patientDTO) {
        return patientRepository.findByFirstnameAndLastname(patientDTO.getFirstname(), patientDTO.getLastname()).getId();
    }
}
