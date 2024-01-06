package com.mediLaboSolutions.backendnote.service;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.model.Note;

import java.util.List;

public interface NoteService {

    public Note getOneNote(String noteId);

    public List<Note> getAllPatientNotes(String patientId);

    public Note createNewPatientNote(NoteDTO noteDTO);

    public Note updatePatientNote(NoteDTO noteDTO);

    public void deleteNote(String noteId);

    public void deleteAllPatientNotes(String patientId);

}
