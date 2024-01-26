package com.mediLaboSolutions.backendnote.controller;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.models.Note;
import com.mediLaboSolutions.backendnote.services.NoteService;
import com.mediLaboSolutions.backendnote.utils.NoteFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class NoteControllerTest {
    @Mock
    private NoteService noteService;

    @InjectMocks
    private NoteController noteController;

    @Test
    @DisplayName("Get all notes for a patient")
    void getAllPatientNotes() {
        // Given
        String patientId = "1";
        List<Note> expectedNotes = List.of(NoteFaker.generateNote(), NoteFaker.generateNote());

        // When
        when(noteService.getAllPatientNotes(patientId)).thenReturn(expectedNotes);
        List<Note> resultNotes = noteController.getAllPatientNotes(patientId);

        // Then
        verify(noteService, times(1)).getAllPatientNotes(patientId);
        assertEquals(expectedNotes, resultNotes);
    }

    @Test
    @DisplayName("Add a new note")
    void addNote() {
        // Given
        NoteDTO noteDTO = new NoteDTO();
        Note createdNote = new Note();

        // When
        when(noteService.createNewPatientNote(noteDTO)).thenReturn(createdNote);
        ResponseEntity<Note> responseEntity = noteController.addNote(noteDTO);

        // Then
        verify(noteService, times(1)).createNewPatientNote(noteDTO);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdNote, responseEntity.getBody());
    }
}