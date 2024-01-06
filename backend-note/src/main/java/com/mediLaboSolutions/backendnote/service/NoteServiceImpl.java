package com.mediLaboSolutions.backendnote.service;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.model.Note;
import com.mediLaboSolutions.backendnote.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

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
