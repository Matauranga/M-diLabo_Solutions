package com.mediLaboSolutions.backendpatientmanagement.services;

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

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPersonById(UUID id) {
        return patientRepository.findById(id);
    }

    public Optional<Patient> getPatientByFirstAndLastName(String firstName, String lastName) { // TODO : A modif
        return null;
    }

    public Patient savePerson(Patient patientToCreate) {
        return patientRepository.save(patientToCreate);
    }

    public void updatePatient(UUID id, Patient patient) { // TODO : A modif
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Patient doesn't exists");
        }

        patientRepository.save(patient);

    }

    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);

    }
}
