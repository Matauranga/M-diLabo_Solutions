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

    @GetMapping("/notes/{patientId}")
    public List<Note> getAllPatientNotes(@PathVariable String patientId) {

        return noteService.getAllPatientNotes(patientId);
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> addNote(@RequestBody NoteDTO noteDTO) {

        return new ResponseEntity<>(noteService.createNewPatientNote(noteDTO), HttpStatus.CREATED);
    }
}
