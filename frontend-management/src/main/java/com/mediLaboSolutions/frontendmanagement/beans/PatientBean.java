package com.mediLaboSolutions.frontendmanagement.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PatientBean {

    private Integer patientId;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String gender;
    private String address;
    private String phonenumber;

    @Override
    public String toString() {
        return "PatientBean{" +
                "id=" + patientId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
