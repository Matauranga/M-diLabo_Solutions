package com.mediLaboSolutions.backendnote.services;

import com.mediLaboSolutions.backendnote.DTO.NoteDTO;
import com.mediLaboSolutions.backendnote.exceptions.NoteNotFoundException;
import com.mediLaboSolutions.backendnote.models.Note;
import com.mediLaboSolutions.backendnote.repositories.NoteRepository;
import com.mediLaboSolutions.backendnote.utils.NoteFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class NoteServiceImplTest {

    @InjectMocks
    NoteServiceImpl noteService;

    @Mock
    NoteRepository noteRepository;

    @DisplayName("Try to get a note")
    @Test
    void getOneNote() {
        //Given an initial Note
        String noteId = "159738d6e5d0d614d2dbcgh3";
        Note note = NoteFaker.generateNote();
        note.setId(noteId);

        //When we try to get
        when(noteRepository.findById(any())).thenReturn(Optional.of(note));
        Note response = noteService.getOneNote(noteId);

        //Then we verify if all is ok
        verify(noteRepository, times(1)).findById(any());
        assertThat(response.getContent()).isEqualTo(note.getContent());

    }

    @DisplayName("Try to get a note but it doesn't exist")
    @Test
    void getOneNoteButNotExist() {
        //Given an initial
        String noteId = "159738d6e5d0d614d2dbcgh3";

        //When we try to get
        when(noteRepository.findById(any())).thenReturn(Optional.empty());
        String response = assertThrows(NoteNotFoundException.class, () -> noteService.getOneNote(noteId)).getMessage();


        //Then we verify if all is ok
        verify(noteRepository, times(1)).findById(any());
        assertThat(response).isEqualTo("Note not found");
    }

    @DisplayName("Try to get all the patient's notes")
    @Test
    void getAllPatientNotes() {
        //Given an initial note list
        List<Note> noteList = List.of(NoteFaker.generateNote(), NoteFaker.generateNote(), NoteFaker.generateNote());

        //When we try to get
        when(noteRepository.findByPatientIdOrderByDateDesc(anyString())).thenReturn(noteList);
        List<Note> response = noteService.getAllPatientNotes("1");

        //Then we verify if all is ok
        verify(noteRepository, times(1)).findByPatientIdOrderByDateDesc(anyString());
        assertThat(response.size()).isEqualTo(3);
    }

    @DisplayName("Try to create a note for a patient")
    @Test
    void createNewPatientNote() {
        //Given an initial NoteDTO
        NoteDTO noteDTO = NoteFaker.generateNoteDTO();

        //When we try to get
        noteService.createNewPatientNote(noteDTO);

        //Then we verify if all is ok
        verify(noteRepository, times(1)).insert((Note) any());

    }
}