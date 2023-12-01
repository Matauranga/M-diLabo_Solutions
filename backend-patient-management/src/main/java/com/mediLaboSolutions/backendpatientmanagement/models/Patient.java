package com.mediLaboSolutions.backendpatientmanagement.models;

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
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

    /**
     * To retrieve patient
     */
    public String getPatientId() {
        return firstname + "-" + lastname;
    }


}
