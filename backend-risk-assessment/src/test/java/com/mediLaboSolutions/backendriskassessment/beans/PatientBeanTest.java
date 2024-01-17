package com.mediLaboSolutions.backendriskassessment.beans;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PatientBeanTest {

    @Test
    public void testConstructorsAndGettersSetters() {
        PatientBean patient = new PatientBean();
        assertThat(patient).isNotNull();

        patient = new PatientBean(100, "John", "Doe", LocalDate.of(1990, 1, 1),
                "Male", "123 Main St", "555-1234");

        patient.setPatientId(10);
        patient.setFirstname("Gio");
        patient.setLastname("GIO");
        patient.setBirthdate(LocalDate.of(2000, 1, 1));
        patient.setGender("Female");
        patient.setAddress("Toulon");
        patient.setPhonenumber("000-1234");

        assertThat(patient.getPatientId()).isEqualTo(10);
        assertThat(patient.getFirstname()).isEqualTo("Gio");
        assertThat(patient.getLastname()).isEqualTo("GIO");
        assertThat(patient.getBirthdate()).isEqualTo(LocalDate.of(2000, 1, 1));
        assertThat(patient.getGender()).isEqualTo("Female");
        assertThat(patient.getAddress()).isEqualTo("Toulon");
        assertThat(patient.getPhonenumber()).isEqualTo("000-1234");
    }

    @Test
    public void testGetAge() {
        PatientBean patient = new PatientBean();
        assertThat(patient.getAge()).isEqualTo(-1);

        patient.setBirthdate(LocalDate.now().minusYears(25));
        assertThat(patient.getAge()).isEqualTo(25);

        // Test avec une date de naissance future
        patient.setBirthdate(null);
        assertThat(patient.getAge()).isEqualTo(-1);
    }

    @Test
    public void testIsUpper30YearsOld() {
        PatientBean patient = new PatientBean();

        // Test avec une personne de moins de 30 ans
        patient.setBirthdate(LocalDate.now().minusYears(25));
        assertThat(patient.isUpper30YearsOld()).isFalse();

        // Test avec une personne de 30 ans ou plus
        patient.setBirthdate(LocalDate.now().minusYears(35));
        assertThat(patient.isUpper30YearsOld()).isTrue();
    }


    @Test
    public void testIsMale() {
        PatientBean patient = new PatientBean();

        // Test avec une personne de sexe masculin
        patient.setGender("M");
        assertThat(patient.isMale()).isTrue();

        // Test avec une personne de sexe féminin
        patient.setGender("F");
        assertThat(patient.isMale()).isFalse();
    }


}