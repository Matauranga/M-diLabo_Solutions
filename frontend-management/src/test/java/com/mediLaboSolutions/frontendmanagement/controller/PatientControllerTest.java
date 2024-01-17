package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.beans.NewPatientBean;
import com.mediLaboSolutions.frontendmanagement.beans.PatientBean;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGatewayPatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PatientControllerTest {

    @Mock
    Model model;

    @Mock
    MSGatewayPatientService msGatewayPatientService;

    @InjectMocks
    PatientController patientController;


    @Test
    void patientListPage() throws Exception {
        //Given


        //When
        String response = patientController.patientList(model);

        //Then
        assertEquals("patientList", response);


    }

    @Test
    void patientInfosPage() throws Exception {
        //Given
        Integer id = 1;

        //When
        String response = patientController.patientInfos(id, model);

        //Then
        assertEquals("patient-details", response);

    }

    @Test
    void newPatientPage() throws Exception {
        //Given

        //When
        String response = patientController.newPatient(model);

        //Then
        assertEquals("create-patient", response);
    }

    @Test
    void createNewPatient() throws Exception {
        //Given

        //When
        String response = patientController.createNewPatient(new NewPatientBean());

        //Then
        assertEquals("redirect:/patients", response);
    }

    @Test
    void editPatient() throws Exception {
        //Given
        Integer id = 1;

        //When
        String response = patientController.editPatient(id, new PatientBean(), model);

        //Then
        assertEquals("redirect:/patients/{id}", response);
    }
}