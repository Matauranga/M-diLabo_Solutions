package com.mediLaboSolutions.backendnote.services;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.models.Note;

import java.util.List;

public interface NoteService {

    public Note getOneNote(String noteId);

    public List<Note> getAllPatientNotes(String patientId);

    public Note createNewPatientNote(NoteDTO noteDTO);

    public Note updatePatientNote(NoteDTO noteDTO);

    public void deleteNote(String noteId);

    public void deleteAllPatientNotes(String patientId);

}
