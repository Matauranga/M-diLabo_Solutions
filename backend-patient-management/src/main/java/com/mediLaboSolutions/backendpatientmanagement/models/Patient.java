package com.mediLaboSolutions.backendpatientmanagement.models;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private LocalDate birthdate;

    @NotBlank
    private String gender;

    private String address;

    private String phonenumber;

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phonenumber + '\'' +
                '}';
    }

    public Patient update(PatientDTO patientDTO) {
        this.firstname = patientDTO.getFirstname();
        this.lastname = patientDTO.getLastname();
        this.birthdate = patientDTO.getBirthdate();
        this.gender = patientDTO.getGender();
        this.address = patientDTO.getAddress();
        this.phonenumber = patientDTO.getPhonenumber();

        return this;
    }


}
