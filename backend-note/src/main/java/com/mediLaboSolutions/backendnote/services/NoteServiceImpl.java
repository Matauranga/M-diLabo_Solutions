package com.mediLaboSolutions.backendnote.services;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.models.Note;
import com.mediLaboSolutions.backendnote.repositories.NoteRepository;

import java.util.List;

public class NoteServiceImpl implements NoteService {

    final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note getOneNote(String noteId) {

        return noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("note non trouvé"));
    }


    public List<Note> getAllPatientNotes(String patientId) {
        return null;
    }


    public Note createNewPatientNote(NoteDTO noteDTO) {
        return null;
    }


    public Note updatePatientNote(NoteDTO noteDTO) {
        return null;
    }


    public void deleteNote(String noteId) {

    }


    public void deleteAllPatientNotes(String patientId) {

    }
}
