package com.mediLaboSolutions.backendnote.services;

import com.mediLaboSolutions.backendnote.repositories.NoteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoteServiceImplTest {

    @InjectMocks
    NoteServiceImpl noteServiceImpl;

    @Mock
    NoteRepository noteRepository;

    @DisplayName("Try to get a note")
    @Test
    void getOneNote() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }

    @DisplayName("Try to get a note but it doesn't exist")
    @Test
    void getOneNoteButNotExist() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }

    @DisplayName("Try to get all the patient's notes")
    @Test
    void getAllPatientNotes() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }

    @DisplayName("Try to create a note for a patient")
    @Test
    void createNewPatientNote() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }

    @DisplayName("Try to update a note")
    @Test
    void updatePatientNote() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }

    @DisplayName("Try to to update a note but it doesn't exist")
    @Test
    void updatePatientNoteButNotExist() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }

    @DisplayName("Try to delete a note")
    @Test
    void deleteNote() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }

    @DisplayName("Try to delete a note but it doesn't exist")
    @Test
    void deleteNoteButNotExist() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }

    @DisplayName("Try to delete all patient notes")
    @Test
    void deleteAllPatientNotes() {
        //Given an initial


        //When we try to get


        //Then we verify if all is ok


    }
}