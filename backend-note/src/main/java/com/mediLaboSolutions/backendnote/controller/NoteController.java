package com.mediLaboSolutions.backendnote.controller;


import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.models.Note;
import com.mediLaboSolutions.backendnote.services.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class NoteController {

    final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Handles HTTP GET request for retrieving all notes of a specific patient.
     *
     * @param patientId the ID of the patient whose notes are to be retrieved
     * @return a list of Note representing all notes of the patient
     */
    @GetMapping("/notes/{patientId}")
    public List<Note> getAllPatientNotes(@PathVariable String patientId) {
        return noteService.getAllPatientNotes(patientId);
    }

    /**
     * Handles HTTP POST request for adding a new note.
     *
     * @param noteDTO the NoteDTO containing information about the new note
     * @return ResponseEntity containing the created Note or a status of CREATED
     */
    @PostMapping("/notes")
    public ResponseEntity<Note> addNote(@RequestBody NoteDTO noteDTO) {
        return new ResponseEntity<>(noteService.createNewPatientNote(noteDTO), HttpStatus.CREATED);
    }
}
