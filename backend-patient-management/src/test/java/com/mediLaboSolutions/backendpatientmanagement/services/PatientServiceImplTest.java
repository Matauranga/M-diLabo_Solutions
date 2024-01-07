package com.mediLaboSolutions.backendpatientmanagement.services;

import com.mediLaboSolutions.backendpatientmanagement.DTO.NewPatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.exceptions.PatientNotFoundException;
import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
import com.mediLaboSolutions.backendpatientmanagement.repositories.PatientRepository;
import com.mediLaboSolutions.backendpatientmanagement.utils.PatientFaker;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("Try to get the list of all patients")
    @Test
    void getAllPatients() {
        //Given an initial list of patients
        List<Patient> patientList = List.of(PatientFaker.generatePatient(), PatientFaker.generatePatient());

        //When we try to get all patients
        when(patientRepository.findAll()).thenReturn(patientList);
        List<PatientDTO> response = patientService.getAllPatients();

        //Then we verify if all is ok
        verify(patientRepository, times(1)).findAll();
        assertThat(response.size()).isEqualTo(2);
    }

    @DisplayName("Try to get a patient")
    @Test
    void getPatientById() {
        //Given an initial patient
        Patient patient = PatientFaker.generatePatient();

        //When we try to get the patient
        when(patientRepository.findById(any())).thenReturn(Optional.of(patient));
        PatientDTO response = patientService.getPatientById(patient.getId());

        //Then we verify if all is ok
        verify(patientRepository, times(1)).findById(any());
        assertThat(response.getLastname()).isEqualTo(patient.getLastname());
        assertThat(response.getBirthdate()).isEqualTo(patient.getBirthdate());
    }

    @DisplayName("Try to save a new patient")
    @Test
    void saveNewPatient() {
        //Given an initial patient
        NewPatientDTO newPatientDTO = PatientFaker.generateNewPatientDTO();

        //When we add the patient
        patientService.saveNewPatient(newPatientDTO);

        //Then we verify if all is ok
        verify(patientRepository, times(1)).save(any());
    }

    @DisplayName("Try to update a patient")
    @Test
    void updatePatient() {
        //Given an initial patient
        Patient patient = PatientFaker.generatePatient();
        PatientDTO patientToUpdateDTO = new PatientDTO(patient);
        patientToUpdateDTO.setAddress("123 Toulon");
        patientToUpdateDTO.setGender("Tardis");

        //When we update the patient
        when(patientRepository.existsById(any())).thenReturn(true);
        when(patientRepository.findById(any())).thenReturn(Optional.of(patient));
        patientService.updatePatient(patientToUpdateDTO);

        //Then we verify if all is ok
        verify(patientRepository, times(1)).existsById(any());
        verify(patientRepository, times(1)).save(any());
        assertThat(patient.getGender()).isEqualTo("Tardis");
        assertThat(patient.getAddress()).isEqualTo("123 Toulon");
    }

    @DisplayName("Try to update a patient but he's not found")
    @Test
    void updatePatientThrowNotFoundException() {
        //Given an initial patient
        Patient patient = PatientFaker.generatePatient();
        PatientDTO newPatientDTO = new PatientDTO(patient);
        newPatientDTO.setAddress("123 Toulon");
        newPatientDTO.setGender("Tardis");

        //When we update the patient
        when(patientRepository.existsById(any())).thenReturn(false);
        String response = assertThrows(PatientNotFoundException.class, () -> patientService.updatePatient(newPatientDTO)).getMessage();

        //Then we verify if all is ok
        verify(patientRepository, times(1)).existsById(any());
        verify(patientRepository, times(0)).save(any());
        assertThat(response).isEqualTo("Patient doesn't exists");
        assertThat(patient.getAddress()).isNotEqualTo(newPatientDTO.getAddress());
    }
}