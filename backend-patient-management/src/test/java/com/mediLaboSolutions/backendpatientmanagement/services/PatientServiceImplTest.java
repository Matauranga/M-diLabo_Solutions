package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.exceptions.PatientAlreadyExistsException;
import com.mediLaboSolutions.backendpatientmanagement.exceptions.PatientNotFoundException;
import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
import com.mediLaboSolutions.backendpatientmanagement.repositories.PatientRepository;
import com.mediLaboSolutions.backendpatientmanagement.utils.PatientFaker;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class PatientServiceImplTest {
    @InjectMocks
    PatientServiceImpl patientService;

    @Mock
    PatientRepository patientRepository;

    @Test
    void getAllPatients() {
        //Given an initial list of patients
        List<Patient> patientList = List.of(PatientFaker.generate(), PatientFaker.generate());

        //When we try to get all patients
        when(patientRepository.findAll()).thenReturn(patientList);
        List<PatientDTO> response = patientService.getAllPatients();

        //Then we verify if all is ok
        verify(patientRepository, times(1)).findAll();
        // assertThat(response).containsAll(patientList);
    }

    @Test
    void getPatientById() {
        //Given an initial patient
        Patient patient = PatientFaker.generate();

        //When we try to get the patient
        when(patientRepository.findById(any())).thenReturn(Optional.of(patient));
        PatientDTO response = patientService.getPatientById(patient.getId());

        //Then we verify if all is ok
        verify(patientRepository, times(1)).findById(any());
        assertThat(response.getLastname()).isEqualTo(patient.getLastname());
        assertThat(response.getBirthdate()).isEqualTo(patient.getBirthdate());
    }

    @Test
    void savePatient() {
        //Given an initial patient
        Patient patient = PatientFaker.generate();

        //When we add the patient
        when(patientRepository.save(any())).thenReturn(patient);
        patientService.savePatient(patient);

        //Then we verify if all is ok
        verify(patientRepository, times(1)).save(any());
    }

    @Test
    void saveNewPatient() {
        //Given an initial patient
        PatientDTO patientDTO = new PatientDTO(PatientFaker.generate());

        //When we add the patient
        when(patientRepository.existsById(any())).thenReturn(false);
        patientService.saveNewPatient(patientDTO);

        //Then we verify if all is ok
        verify(patientRepository, times(1)).existsById(any());
        verify(patientRepository, times(1)).save(any());
    }

    @Test
    void saveNewPatientButAlreadyExist() {
        //Given an initial patient
        PatientDTO patientDTO = new PatientDTO(PatientFaker.generate());

        //When we add the patient
        when(patientRepository.existsById(any())).thenReturn(true);
        String response = assertThrows(PatientAlreadyExistsException.class, () -> patientService.saveNewPatient(patientDTO)).getMessage();

        //Then we verify if all is ok
        verify(patientRepository, times(1)).existsById(any());
        verify(patientRepository, times(0)).save(any());
        assertThat(response).contains("This patient already exist in data base.");
    }

    @Test
    void updatePatient() {
        //Given an initial patient
        Patient patient = PatientFaker.generate();
        PatientDTO patientDTO = new PatientDTO(patient);
        patientDTO.setAddress("123 Toulon");
        patientDTO.setGender("Tardis");

        //When we update the patient
        when(patientRepository.existsById(any())).thenReturn(true);
        when(patientRepository.findById(any())).thenReturn(Optional.of(patient));
        patientService.updatePatient(patientDTO);

        //Then we verify if all is ok
        verify(patientRepository, times(1)).existsById(any());
        verify(patientRepository, times(1)).save(any());
        assertThat(patient.getGender()).isEqualTo("Tardis");
        assertThat(patient.getAddress()).isEqualTo("123 Toulon");

    }

    @Test
    void updatePatientThrowNotFoundException() {
        //Given an initial patient
        Patient patient = PatientFaker.generate();
        PatientDTO patientDTO = new PatientDTO(patient);
        patientDTO.setAddress("123 Toulon");
        patientDTO.setGender("Tardis");

        //When we update the patient
        when(patientRepository.existsById(any())).thenReturn(false);
        String response = assertThrows(PatientNotFoundException.class, () -> patientService.updatePatient(patientDTO)).getMessage();

        //Then we verify if all is ok
        verify(patientRepository, times(1)).existsById(any());
        verify(patientRepository, times(0)).save(any());
        assertThat(response).isEqualTo("Patient doesn't exists");
        assertThat(patient.getAddress()).isNotEqualTo(patientDTO.getAddress());
    }

    @Test
    void deletePatient() {
        //Given an initial patient
        Patient patient = PatientFaker.generate();
        PatientDTO patientDTO = new PatientDTO(patient);

        //When we delete the patient
        when(patientRepository.findById(any())).thenReturn(Optional.of(patient));
        patientService.deletePatient(patientDTO);

        //Then we verify if all is ok
        verify(patientRepository, times(1)).deleteById(any());
    }
}