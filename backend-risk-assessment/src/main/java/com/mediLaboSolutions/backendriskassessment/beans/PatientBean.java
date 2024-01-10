package com.mediLaboSolutions.backendriskassessment.beans;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientBean {

    Integer patientId;

    @NotBlank
    String firstname;

    @NotBlank
    String lastname;

    @NotBlank
    LocalDate birthdate;

    @NotBlank
    String gender;

    String address;

    String phonenumber;

    public int getAge() {
        if (birthdate == null) {
            return -1;
        }
        LocalDate birthDay = LocalDate.parse(birthdate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return Period.between(birthDay, LocalDate.now()).getYears();
    }

    public boolean isUnder30YearsOld() {
        return getAge() < 30;
    }

    public boolean isMale() {
        return gender.equals("M");
    }

}
