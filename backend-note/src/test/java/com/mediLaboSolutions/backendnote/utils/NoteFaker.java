package com.mediLaboSolutions.backendnote.utils;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.models.Note;
import net.datafaker.Faker;

import java.util.Date;
import java.util.Locale;

public class NoteFaker {

    private static final Faker faker = new Faker(Locale.US);

    public static Note generateNote() {
        Note note = new Note();

        note.setPatientId("1");
        note.setDate(new Date());
        note.setContent(faker.lorem().paragraph());

        return note;
    }

    public static NoteDTO generateNoteDTO() {
        NoteDTO note = new NoteDTO();

        note.setPatientId("1");
        note.setContent(faker.lorem().paragraph());

        return note;
    }

}
