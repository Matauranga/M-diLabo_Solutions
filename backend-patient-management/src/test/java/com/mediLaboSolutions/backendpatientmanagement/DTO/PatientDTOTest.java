package com.mediLaboSolutions.backendpatientmanagement.DTO;

import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PatientDTOTest {

    @Test
    public void testConstructorsAndGetters() {
        PatientDTO patientDTO = new PatientDTO();
        assertThat(patientDTO).isNotNull();

        patientDTO = new PatientDTO(100, "gio", "GIO", LocalDate.of(1990, 1, 1),
                "Male", "123 Main St", "555-1234");

        assertThat(patientDTO.getPatientId()).isEqualTo(100);
        assertThat(patientDTO.getFirstname()).isEqualTo("gio");
        assertThat(patientDTO.getLastname()).isEqualTo("GIO");
        assertThat(patientDTO.getBirthdate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(patientDTO.getGender()).isEqualTo("Male");
        assertThat(patientDTO.getAddress()).isEqualTo("123 Main St");
        assertThat(patientDTO.getPhonenumber()).isEqualTo("555-1234");

        patientDTO.setPatientId(10);
        patientDTO.setFirstname("newGio");
        patientDTO.setLastname("newGIO");
        patientDTO.setBirthdate(LocalDate.of(2000, 1, 1));
        patientDTO.setGender("Female");
        patientDTO.setAddress("Toulon");
        patientDTO.setPhonenumber("000-1234");

        assertThat(patientDTO.getPatientId()).isEqualTo(10);
        assertThat(patientDTO.getFirstname()).isEqualTo("newGio");
        assertThat(patientDTO.getLastname()).isEqualTo("newGIO");
        assertThat(patientDTO.getBirthdate()).isEqualTo(LocalDate.of(2000, 1, 1));
        assertThat(patientDTO.getGender()).isEqualTo("Female");
        assertThat(patientDTO.getAddress()).isEqualTo("Toulon");
        assertThat(patientDTO.getPhonenumber()).isEqualTo("000-1234");
    }

    @Test
    public void testConversionFromPatient() {
        Patient patient = new Patient(10, "gio", "GIO", LocalDate.of(1990, 1, 1),
                "Male", "123 Main St", "555-1234");
        PatientDTO patientDTO = new PatientDTO(patient);

        assertThat(patientDTO.getPatientId()).isEqualTo(10);
        assertThat(patientDTO.getFirstname()).isEqualTo("gio");
        assertThat(patientDTO.getLastname()).isEqualTo("GIO");
        assertThat(patientDTO.getBirthdate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(patientDTO.getGender()).isEqualTo("Male");
        assertThat(patientDTO.getAddress()).isEqualTo("123 Main St");
        assertThat(patientDTO.getPhonenumber()).isEqualTo("555-1234");
    }


}