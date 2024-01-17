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

    /**
     * Retrieves a single note by its ID.
     *
     * @param noteId the ID of the note to retrieve
     * @return the Note representing the retrieved note
     * @throws NoteNotFoundException if the note is not found
     */
    public Note getOneNote(String noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));
    }

    /**
     * Retrieves all notes of a specific patient, ordered by date in descending order.
     *
     * @param patientId the ID of the patient whose notes are to be retrieved
     * @return a list of Note representing all notes of the patient
     */
    public List<Note> getAllPatientNotes(String patientId) {
        return noteRepository.findByPatientIdOrderByDateDesc(patientId);
    }

    /**
     * Creates a new note for a patient based on the provided NoteDTO.
     *
     * @param noteDTO the NoteDTO containing information about the new note
     * @return the created Note
     */
    public Note createNewPatientNote(NoteDTO noteDTO) {
        Note noteToCreate = new Note();
        noteToCreate.setPatientId(noteDTO.getPatientId());
        noteToCreate.setContent(noteDTO.getContent());
        noteToCreate.setDate(new Date());

        noteRepository.insert(noteToCreate);

        return noteToCreate;
    }
}
