package com.mediLaboSolutions.frontendmanagement.beans;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewPatientBean {    @NotBlank
    String firstname;
    @NotBlank
    String lastname;
    @NotBlank
    LocalDate birthdate;
    @NotBlank
    String gender;

    String address;

    String phonenumber;

}
