package com.mediLaboSolutions.frontendmanagement.beans;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NewPatientBeanTest {

    @Test
    public void testConstructorsAndGettersSetters() {
        NewPatientBean patient = new NewPatientBean();
        assertThat(patient).isNotNull();

        patient = new NewPatientBean("John", "Doe", LocalDate.of(1990, 1, 1),
                "Male", "123 Main St", "555-1234");

        patient.setFirstname("Gio");
        patient.setLastname("GIO");
        patient.setBirthdate(LocalDate.of(2000, 1, 1));
        patient.setGender("Female");
        patient.setAddress("Toulon");
        patient.setPhonenumber("000-1234");

        assertThat(patient.getFirstname()).isEqualTo("Gio");
        assertThat(patient.getLastname()).isEqualTo("GIO");
        assertThat(patient.getBirthdate()).isEqualTo(LocalDate.of(2000, 1, 1));
        assertThat(patient.getGender()).isEqualTo("Female");
        assertThat(patient.getAddress()).isEqualTo("Toulon");
        assertThat(patient.getPhonenumber()).isEqualTo("000-1234");
    }

}