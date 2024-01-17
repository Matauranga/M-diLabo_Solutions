package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.NoteBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGatewayNoteService;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGatewayPatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class NoteControllerTest {

    @Mock
    MSGatewayNoteService msGatewayNoteService;

    @InjectMocks
    NoteController noteController;


    @Test
    void addNewNote() throws Exception {
        //Given
        Integer patientId = 1;
        NoteBean noteBean = new NoteBean("123", patientId.toString(), "", new Date());

        //When
        when(msGatewayNoteService.createNewNote(any())).thenReturn(noteBean);
        String response = noteController.addNewNote(patientId, noteBean);

        //Then
        assertEquals("redirect:/patients/{id}", response);
    }
}