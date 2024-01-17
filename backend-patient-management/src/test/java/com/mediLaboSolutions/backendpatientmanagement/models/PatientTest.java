package com.mediLaboSolutions.backendpatientmanagement.models;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientTest {

    @Test
    public void testConstructorsAndGetters() {
        Patient patient = new Patient();
        assertThat(patient).isNotNull();

        patient = new Patient(10, "gio", "GIO", LocalDate.of(1990, 1, 1),
                "Male", "123 Main St", "555-1234");

        assertThat(patient.getId()).isEqualTo(10);
        assertThat(patient.getFirstname()).isEqualTo("gio");
        assertThat(patient.getLastname()).isEqualTo("GIO");
        assertThat(patient.getBirthdate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(patient.getGender()).isEqualTo("Male");
        assertThat(patient.getAddress()).isEqualTo("123 Main St");
        assertThat(patient.getPhonenumber()).isEqualTo("555-1234");

        patient.setId(100);
        patient.setFirstname("newGio");
        patient.setLastname("newGIO");
        patient.setBirthdate(LocalDate.of(2000, 1, 1));
        patient.setGender("Female");
        patient.setAddress("Toulon");
        patient.setPhonenumber("000-1234");

        assertThat(patient.getId()).isEqualTo(100);
        assertThat(patient.getFirstname()).isEqualTo("newGio");
        assertThat(patient.getLastname()).isEqualTo("newGIO");
        assertThat(patient.getBirthdate()).isEqualTo(LocalDate.of(2000, 1, 1));
        assertThat(patient.getGender()).isEqualTo("Female");
        assertThat(patient.getAddress()).isEqualTo("Toulon");
        assertThat(patient.getPhonenumber()).isEqualTo("000-1234");



    }

    @Test
    public void testToString() {
        Patient patient = new Patient(10, "gio", "GIO", LocalDate.of(1990, 1, 1),
                "Male", "Toulon", "000-1234");

        String expectedToString = "Patient{" +
                "patientId=10" +
                ", firstname='gio'" +
                ", lastName='GIO'" +
                ", birthdate=1990-01-01" +
                ", gender='Male'" +
                ", address='Toulon'" +
                ", phoneNumber='000-1234'}";

        assertThat(patient.toString()).isEqualTo(expectedToString);
    }

    @Test
    public void testUpdate() {
        Patient patient = new Patient();
        PatientDTO patientDTO = new PatientDTO(10, "gio", "GIO", LocalDate.of(1990, 1, 1),
                "Male", "123 Main St", "555-1234");

        patient.update(patientDTO);

        assertThat(patientDTO.getPatientId()).isEqualTo(10);
        assertThat(patientDTO.getFirstname()).isEqualTo("gio");
        assertThat(patientDTO.getLastname()).isEqualTo("GIO");
        assertThat(patientDTO.getBirthdate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(patientDTO.getGender()).isEqualTo("Male");
        assertThat(patientDTO.getAddress()).isEqualTo("123 Main St");
        assertThat(patientDTO.getPhonenumber()).isEqualTo("555-1234");
    }

}