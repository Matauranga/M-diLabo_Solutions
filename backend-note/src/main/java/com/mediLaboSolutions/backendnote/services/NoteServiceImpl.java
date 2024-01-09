package com.mediLaboSolutions.backendnote.services;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.exceptions.NoteNotFoundException;
import com.mediLaboSolutions.backendnote.models.Note;
import com.mediLaboSolutions.backendnote.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note getOneNote(String noteId) {

        return noteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));
    }

    public List<Note> getAllPatientNotes(String patientId) {

        return noteRepository.findByPatientIdOrderByDateDesc(patientId);
    }

    public Note createNewPatientNote(NoteDTO noteDTO) {

        Note noteToCreate = new Note();
        noteToCreate.setPatientId(noteDTO.getPatientId());
        noteToCreate.setContent(noteDTO.getContent());
        noteToCreate.setDate(new Date());

        noteRepository.insert(noteToCreate);

        return noteToCreate;
    }
}
