package com.mediLaboSolutions.backendpatientmanagement.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NewPatientDTOTest {

    @Test
    public void testConstructorsAndGetters() {
        NewPatientDTO patientDTO = new NewPatientDTO();
        assertThat(patientDTO).isNotNull();

        patientDTO = new NewPatientDTO("gio", "GIO", LocalDate.of(1990, 1, 1),
                "Male", "123 Main St", "555-1234");

        assertThat(patientDTO.getFirstname()).isEqualTo("gio");
        assertThat(patientDTO.getLastname()).isEqualTo("GIO");
        assertThat(patientDTO.getBirthdate()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(patientDTO.getGender()).isEqualTo("Male");
        assertThat(patientDTO.getAddress()).isEqualTo("123 Main St");
        assertThat(patientDTO.getPhonenumber()).isEqualTo("555-1234");


        patientDTO.setFirstname("newGio");
        patientDTO.setLastname("newGIO");
        patientDTO.setBirthdate(LocalDate.of(2000, 1, 1));
        patientDTO.setGender("Female");
        patientDTO.setAddress("Toulon");
        patientDTO.setPhonenumber("000-1234");

        assertThat(patientDTO.getFirstname()).isEqualTo("newGio");
        assertThat(patientDTO.getLastname()).isEqualTo("newGIO");
        assertThat(patientDTO.getBirthdate()).isEqualTo(LocalDate.of(2000, 1, 1));
        assertThat(patientDTO.getGender()).isEqualTo("Female");
        assertThat(patientDTO.getAddress()).isEqualTo("Toulon");
        assertThat(patientDTO.getPhonenumber()).isEqualTo("000-1234");
    }

}