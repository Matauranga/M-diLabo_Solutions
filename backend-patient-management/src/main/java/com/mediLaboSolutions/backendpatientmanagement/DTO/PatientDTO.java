package com.mediLaboSolutions.backendpatientmanagement.DTO;

import com.mediLaboSolutions.backendpatientmanagement.models.Patient;
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
    Integer patentId;
    String firstname;
    String lastname;
    LocalDate birthdate;
    String gender;
    String address;
    String phonenumber;

    public PatientDTO(Patient patient) {
        this.patentId = patient.getId();
        this.firstname = patient.getFirstname();
        this.lastname = patient.getLastname();
        this.birthdate = patient.getBirthdate();
        this.gender = patient.getGender();
        this.address = patient.getAddress();
        this.phonenumber = patient.getPhonenumber();
    }

}
