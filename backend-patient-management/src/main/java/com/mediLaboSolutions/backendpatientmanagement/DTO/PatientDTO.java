package com.mediLaboSolutions.backendpatientmanagement.DTO;

import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
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
public class PatientDTO {

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

    public PatientDTO(Patient patient) {
        this.patientId = patient.getId();
        this.firstname = patient.getFirstname();
        this.lastname = patient.getLastname();
        this.birthdate = patient.getBirthdate();
        this.gender = patient.getGender();
        this.address = patient.getAddress();
        this.phonenumber = patient.getPhonenumber();
    }
}
