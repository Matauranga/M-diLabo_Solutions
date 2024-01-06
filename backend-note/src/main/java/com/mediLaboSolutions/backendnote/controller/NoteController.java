package com.mediLaboSolutions.backendnote.controller;


import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.models.Note;
import com.mediLaboSolutions.backendnote.repositories.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class NoteController { //TODO revoir path avec Frank

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes/{patientId}/{id}")
    public Optional<Note> getNote(@PathVariable String patientId, @PathVariable String id) {

        Optional<Note> note = noteRepository.findById(id);

        return note;
    }

    @GetMapping("/notes/{patientId}")
    public List<Note> getAllPatientNotes(@PathVariable String patientId) {

        List<Note> notes = noteRepository.findByPatientIdOrderByDateDesc(patientId);

        return notes;
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> addNote(@RequestBody NoteDTO noteDTO) {

        Note noteToCreate = new Note();
        noteToCreate.setPatientId(noteDTO.getPatientId());
        noteToCreate.setContent(noteDTO.getContent());
        noteToCreate.setDate(new Date());

        noteRepository.insert(noteToCreate);

        return new ResponseEntity<>(noteToCreate, HttpStatus.CREATED);
    }


}
