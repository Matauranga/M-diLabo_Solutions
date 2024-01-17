package com.mediLaboSolutions.backendnote.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NoteTest {

    @Test
    public void testConstructorsAndGettersSetters() {
        Note note = new Note();
        assertThat(note).isNotNull();

        note = new Note("1", "patient123", "Content of the note", new Date());
        assertThat(note).isNotNull();
        assertThat(note.getId()).isEqualTo("1");
        assertThat(note.getPatientId()).isEqualTo("patient123");
        assertThat(note.getContent()).isEqualTo("Content of the note");
        assertThat(note.getDate()).isNotNull();

        note.setId("2");
        note.setPatientId("patient456");
        note.setContent("New content");
        note.setDate(new Date());

        assertThat(note.getId()).isEqualTo("2");
        assertThat(note.getPatientId()).isEqualTo("patient456");
        assertThat(note.getContent()).isEqualTo("New content");
        assertThat(note.getDate()).isNotNull();

    }

}