package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.exceptions.PatientAlreadyExistsException;
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

    public void saveNewPatient(PatientDTO patientDTO) {
//        if (patientRepository.existsById(patientDTO.getPatientId())) {
//            throw new PatientAlreadyExistsException("This patient already exist in data base.");
//        }
        Patient patient = new Patient();
        patient.update(patientDTO);
        patientRepository.save(patient);
    }

    public void updatePatient(PatientDTO updatedPatientDto) {
        if (!patientRepository.existsById(updatedPatientDto.getPatientId())) {
            throw new PatientNotFoundException("Patient doesn't exists");
        }

        Patient updatedPatient = patientRepository.findById(updatedPatientDto.getPatientId())
                .orElseThrow()
                .update(updatedPatientDto);

        patientRepository.save(updatedPatient);
    }

    public void deletePatient(PatientDTO patientDTO) {

        patientRepository.deleteById(patientDTO.getPatientId());
    }
}
