package com.mediLaboSolutions.backendpatientmanagement.utils;

import com.github.javafaker.Faker;
import com.mediLaboSolutions.backendpatientmanagement.DTO.NewPatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.models.Patient;

import java.time.LocalDate;
import java.util.Locale;

public class PatientFaker {
// patient.setBirthdate(LocalDate.of(faker.number().numberBetween(1920, 2020), faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 28)));

    private static final Faker faker = new Faker(Locale.US);


    public static Patient generatePatient() {
        Patient patient = new Patient();

        patient.setFirstname(faker.address().firstName());
        patient.setLastname(faker.address().lastName());
        patient.setBirthdate(null);
        patient.setGender("M");
        patient.setAddress(faker.lorem().sentence());
        patient.setPhonenumber(faker.phoneNumber().cellPhone());

        return patient;
    }

    public static NewPatientDTO generateNewPatientDTO() {
        NewPatientDTO newPatientDTO = new NewPatientDTO();

        newPatientDTO.setFirstname(faker.address().firstName());
        newPatientDTO.setLastname(faker.address().lastName());
        newPatientDTO.setBirthdate(null);
        newPatientDTO.setGender("M");
        newPatientDTO.setAddress(faker.lorem().sentence());
        newPatientDTO.setPhonenumber(faker.phoneNumber().cellPhone());

        return newPatientDTO;
    }

}
