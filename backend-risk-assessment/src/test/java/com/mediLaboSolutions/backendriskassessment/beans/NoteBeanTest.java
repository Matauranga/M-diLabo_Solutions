package com.mediLaboSolutions.backendriskassessment.beans;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NoteBeanTest {

    @Test
    public void testConstructorsAndGettersSetters() {
        Date date = new Date("1990/01/01");

        NoteBean note = new NoteBean();
        assertThat(note).isNotNull();

        note = new NoteBean("idNote_1", "patientId_1", "Test", date);

        note.setId("idNote_10");
        note.setPatientId("patientId_10");
        note.setContent("New test");
        note.setDate(date);

        assertThat(note.getId()).isEqualTo("idNote_10");
        assertThat(note.getPatientId()).isEqualTo("patientId_10");
        assertThat(note.getContent()).isEqualTo("New test");
        assertThat(note.getDate()).isEqualTo(date);
    }
}