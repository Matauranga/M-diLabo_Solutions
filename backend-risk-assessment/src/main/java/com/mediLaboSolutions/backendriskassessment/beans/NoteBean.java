package com.mediLaboSolutions.backendriskassessment.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteBean {

    private String id;

    private String patientId;

    private String content;

    private Date date;

}
