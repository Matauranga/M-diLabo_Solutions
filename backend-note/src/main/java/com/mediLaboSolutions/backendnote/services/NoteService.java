package com.mediLaboSolutions.backendnote.services;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.models.Note;

import java.util.List;

public interface NoteService {

    /**
     * Retrieves a single note by its ID.
     *
     * @param noteId the ID of the note to retrieve
     * @return the Note representing the retrieved note
     */
    Note getOneNote(String noteId);

    /**
     * Retrieves all notes of a specific patient.
     *
     * @param patientId the ID of the patient whose notes are to be retrieved
     * @return a list of Note representing all notes of the patient
     */
    List<Note> getAllPatientNotes(String patientId);

    /**
     * Creates a new note for a patient based on the provided NoteDTO.
     *
     * @param noteDTO the NoteDTO containing information about the new note
     * @return the created Note
     */
    Note createNewPatientNote(NoteDTO noteDTO);
}
