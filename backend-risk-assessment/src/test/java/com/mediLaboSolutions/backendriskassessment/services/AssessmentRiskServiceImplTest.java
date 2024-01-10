package com.mediLaboSolutions.backendriskassessment.services;

import com.mediLaboSolutions.backendriskassessment.DTO.AssessmentResultDTO;
import com.mediLaboSolutions.backendriskassessment.beans.NoteBean;
import com.mediLaboSolutions.backendriskassessment.beans.PatientBean;
import com.mediLaboSolutions.backendriskassessment.proxies.MSBackendNote;
import com.mediLaboSolutions.backendriskassessment.proxies.MSBackendPatientManagement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.mediLaboSolutions.backendriskassessment.constants.TermsRiskAssessmentResults.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AssessmentRiskServiceImplTest{
    @InjectMocks
    AssessmentRiskServiceImpl assessmentRiskService;
    @Mock
    MSBackendPatientManagement msBackendPatientManagement;
    @Mock
    MSBackendNote msBackendNote;

    /**
     *                  FIRST SET OF TESTS Patient : Age : +30
     *                                               Genre : No //TODO
     */

    @DisplayName("Get risk assessment for a patient (30 +) result : None")
    @Test
    void getRiskAssessmentResultMore30YearsOldCase1() {
        //Given an initial patient and notes list
        PatientBean patient = getPatientUpper30();
        List<NoteBean> patientNotes = get1Note();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(NONE);
    }

    @DisplayName("Get risk assessment for a patient (30 +) result : Borderline")
    @Test
    void getRiskAssessmentResultMore30YearsOldCase2() {
        //Given an initial patient and notes list
        PatientBean patient = getPatientUpper30();
        List<NoteBean> patientNotes = get3Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(BORDERLINE);
    }

    @DisplayName("Get risk assessment for a patient (30 +) result :In Danger")
    @Test
    void getRiskAssessmentResultMore30YearsOldCase3() {
        //Given an initial patient and notes list
        PatientBean patient = getPatientUpper30();
        List<NoteBean> patientNotes = get6Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(IN_DANGER);
    }

    @DisplayName("Get risk assessment for a patient (30 +) result : Early Onset")
    @Test
    void getRiskAssessmentResultMore30YearsOldCase4() {
        //Given an initial patient and notes list
        PatientBean patient = getPatientUpper30();
        List<NoteBean> patientNotes = get8Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(EARLY_ONSET);
    }

    /**
     *                  SECOND SET OF TESTS Patient : Age : -30
     *                                               Genre : Male
     */

    @DisplayName("Get risk assessment for Male (-30) result : None")
    @Test
    void getRiskAssessmentResultForMaleUnder30YearsOldCase1() {
        //Given an initial patient and notes list
        PatientBean patient = getMalePatientUnder30();
        List<NoteBean> patientNotes = get2Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(NONE);
    }

    @DisplayName("Get risk assessment for Male (-30) result :In Danger")
    @Test
    void getRiskAssessmentResultForMaleUnder30YearsOldCase2() {
        //Given an initial patient and notes list
        PatientBean patient = getMalePatientUnder30();
        List<NoteBean> patientNotes = get4Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(IN_DANGER);
    }

    @DisplayName("Get risk assessment for Male (-30) result : Early Onset")
    @Test
    void getRiskAssessmentResultForMaleUnder30YearsOldCase3() {
        //Given an initial patient and notes list
        PatientBean patient = getMalePatientUnder30();
        List<NoteBean> patientNotes = get7Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(EARLY_ONSET);
    }

    /**
     *                  THIRD SET OF TESTS Patient : Age : -30
     *                                               Genre : Female
     */

    @DisplayName("Get risk assessment for Female (-30) result : None")
    @Test
    void getRiskAssessmentResultForFemaleUnder30YearsOldCase1() {
        //Given an initial patient and notes list
        PatientBean patient = getFemalePatientUnder30();
        List<NoteBean> patientNotes = get3Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(NONE);
    }

    @DisplayName("Get risk assessment for Female (-30) result :In Danger")
    @Test
    void getRiskAssessmentResultForFemaleUnder30YearsOldCase2() {
        //Given an initial patient and notes list
        PatientBean patient = getFemalePatientUnder30();
        List<NoteBean> patientNotes = get6Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(IN_DANGER);
    }

    @DisplayName("Get risk assessment for Female (-30) result : Early Onset")
    @Test
    void getRiskAssessmentResultForFemaleUnder30YearsOldCase3() {
        //Given an initial patient and notes list
        PatientBean patient = getFemalePatientUnder30();
        List<NoteBean> patientNotes = get8Notes();

        //When we try to ge result
        when(msBackendPatientManagement.patientInfos(any())).thenReturn(patient);
        when(msBackendNote.getPatientNotes(any())).thenReturn(patientNotes);
        AssessmentResultDTO response = assessmentRiskService.getRiskAssessmentResult(patient.getPatientId());

        //Then we verify if all is ok
        verify(msBackendPatientManagement, times(1)).patientInfos(any());
        verify(msBackendNote, times(1)).getPatientNotes(any());
        assertThat(response.getResult()).isEqualTo(EARLY_ONSET);
    }


    /**
     *  Prepare patients
     */

    private static PatientBean getPatientUpper30() {
        return new PatientBean(10, "Gio", "GIO",
                LocalDate.of(1900, 1, 1), "M",
                "1 rue OUI", "0000-111-222");
    }

    private static PatientBean getMalePatientUnder30() {
        return new PatientBean(11, "Gio", "GIO",
                LocalDate.of(2000, 1, 1), "M",
                "1 rue OUI", "0000-111-222");
    }

    private static PatientBean getFemalePatientUnder30() {
        return new PatientBean(12, "Gio", "GIO",
                LocalDate.of(2000, 1, 1), "F",
                "1 rue OUI", "0000-111-222");
    }

    /**
     * Prepare Notes Lists
     */
    private static List<NoteBean> get1Note() {
        NoteBean note1 = new NoteBean("123", "10", "Microalbumine", new Date());
        return List.of(note1);
    }

    private static List<NoteBean> get2Notes() {
        NoteBean note1 = new NoteBean("123", "10", "Microalbumine", new Date());
        NoteBean note2 = new NoteBean("124", "10", "Taille", new Date());

        return List.of(note1, note2);
    }

    private static List<NoteBean> get3Notes() {
        NoteBean note1 = new NoteBean("123", "10", "Microalbumine", new Date());
        NoteBean note2 = new NoteBean("124", "10", "Taille", new Date());
        NoteBean note3 = new NoteBean("125", "10", "Poids", new Date());

        return List.of(note1, note2, note3);
    }

    private static List<NoteBean> get4Notes() {
        NoteBean note1 = new NoteBean("123", "10", "Microalbumine", new Date());
        NoteBean note2 = new NoteBean("124", "10", "Taille", new Date());
        NoteBean note3 = new NoteBean("125", "10", "Poids", new Date());
        NoteBean note4 = new NoteBean("126", "10", "Fume", new Date());

        return List.of(note1, note2, note3, note4);
    }

    private static List<NoteBean> get5Notes() {
        NoteBean note1 = new NoteBean("123", "10", "Microalbumine", new Date());
        NoteBean note2 = new NoteBean("124", "10", "Taille", new Date());
        NoteBean note3 = new NoteBean("125", "10", "Poids", new Date());
        NoteBean note4 = new NoteBean("126", "10", "Fume", new Date());
        NoteBean note5 = new NoteBean("127", "10", "Anormal", new Date());

        return List.of(note1, note2, note3, note4, note5);
    }

    private static List<NoteBean> get6Notes() {
        NoteBean note1 = new NoteBean("123", "10", "Microalbumine", new Date());
        NoteBean note2 = new NoteBean("124", "10", "Taille", new Date());
        NoteBean note3 = new NoteBean("125", "10", "Poids", new Date());
        NoteBean note4 = new NoteBean("126", "10", "Fume", new Date());
        NoteBean note5 = new NoteBean("127", "10", "Anormal", new Date());
        NoteBean note6 = new NoteBean("128", "10", "Cholestérol", new Date());

        return List.of(note1, note2, note3, note4, note5, note6);
    }

    private static List<NoteBean> get7Notes() {
        NoteBean note1 = new NoteBean("123", "10", "Microalbumine", new Date());
        NoteBean note2 = new NoteBean("124", "10", "Taille", new Date());
        NoteBean note3 = new NoteBean("125", "10", "Poids", new Date());
        NoteBean note4 = new NoteBean("126", "10", "Fume", new Date());
        NoteBean note5 = new NoteBean("127", "10", "Anormal", new Date());
        NoteBean note6 = new NoteBean("128", "10", "Cholestérol", new Date());
        NoteBean note7 = new NoteBean("129", "10", "Vertiges", new Date());

        return List.of(note1, note2, note3, note4, note5, note6, note7);
    }

    private static List<NoteBean> get8Notes() {
        NoteBean note1 = new NoteBean("123", "10", "Microalbumine", new Date());
        NoteBean note2 = new NoteBean("124", "10", "Taille", new Date());
        NoteBean note3 = new NoteBean("125", "10", "Poids", new Date());
        NoteBean note4 = new NoteBean("126", "10", "Fume", new Date());
        NoteBean note5 = new NoteBean("127", "10", "Anormal", new Date());
        NoteBean note6 = new NoteBean("128", "10", "Cholestérol", new Date());
        NoteBean note7 = new NoteBean("129", "10", "Vertiges", new Date());
        NoteBean note8 = new NoteBean("130", "10", "Rechute", new Date());

        return List.of(note1, note2, note3, note4, note5, note6, note7, note8);
    }
}