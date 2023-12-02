package com.mediLaboSolutions.backendpatientmanagement.utils;

import com.github.javafaker.Faker;
import com.mediLaboSolutions.backendpatientmanagement.models.Patient;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class PatientFaker {

    private static final Faker faker = new Faker(Locale.US);


    public static Patient generate() {
        Patient patient = new Patient();

        patient.setId(UUID.randomUUID());
        patient.setFirstname(faker.address().firstName());
        patient.setLastname(faker.address().lastName());
        patient.setBirthdate(LocalDate.of(faker.number().numberBetween(1920, 2020), faker.number().numberBetween(1,12), faker.number().numberBetween(1,28)));
        patient.setGender("M");
        patient.setAddress(faker.lorem().sentence());
        patient.setPhonenumber(faker.phoneNumber().cellPhone());

        return patient;
    }

}
