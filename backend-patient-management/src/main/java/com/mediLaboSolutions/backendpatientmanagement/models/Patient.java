package com.mediLaboSolutions.backendpatientmanagement.models;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientToUpdateDTO;
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

;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public Patient update(PatientToUpdateDTO patientToUpdateDTO) {
        this.firstname = patientToUpdateDTO.getFirstname();
        this.lastname = patientToUpdateDTO.getLastname();
        this.birthdate = patientToUpdateDTO.getBirthdate();
        this.gender = patientToUpdateDTO.getGender();
        this.address = patientToUpdateDTO.getAddress();
        this.phonenumber = patientToUpdateDTO.getPhonenumber();

        return this;
    }


}
