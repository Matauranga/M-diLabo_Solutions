package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.NewPatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientToUpdateDTO;
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

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientDTO::new)
                .toList();
    }

    public PatientDTO getPatientById(Integer patientId) {

        return new PatientDTO(patientRepository.findById(patientId).orElseThrow());
    }

    public Patient savePatient(Patient patientToCreate) {
        return patientRepository.save(patientToCreate);
    }

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

    public void updatePatient(PatientToUpdateDTO patientToUpdateDTO) {
        if (!patientRepository.existsById(patientToUpdateDTO.getPatientId())) {
            throw new PatientNotFoundException("Patient doesn't exists");
        }

        Patient updatedPatient = patientRepository.findById(patientToUpdateDTO.getPatientId())
                .orElseThrow()
                .update(patientToUpdateDTO);

        patientRepository.save(updatedPatient);
    }
}
