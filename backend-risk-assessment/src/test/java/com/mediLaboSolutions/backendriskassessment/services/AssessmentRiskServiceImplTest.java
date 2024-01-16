package com.mediLaboSolutions.backendriskassessment.services;

import com.mediLaboSolutions.backendriskassessment.DTO.AssessmentResultDTO;
import com.mediLaboSolutions.backendriskassessment.beans.NoteBean;
import com.mediLaboSolutions.backendriskassessment.beans.PatientBean;
import com.mediLaboSolutions.backendriskassessment.constants.AllTriggerTerms;
import com.mediLaboSolutions.backendriskassessment.proxies.MSBackendNote;
import com.mediLaboSolutions.backendriskassessment.proxies.MSBackendPatientManagement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mediLaboSolutions.backendriskassessment.constants.TermsRiskAssessmentResults.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AssessmentRiskServiceImplTest {
    @InjectMocks
    AssessmentRiskServiceImpl assessmentRiskService;
    @Mock
    MSBackendPatientManagement msBackendPatientManagement;
    @Mock
    MSBackendNote msBackendNote;

    /**
     *                  FIRST SET OF TESTS Patient : Age : +30
     *                                               Genre : Don't matter
     */

    @DisplayName("Get risk assessment for a patient (30 +) result : None")
    @Test
    void getRiskAssessmentResultMore30YearsOldCase1() {
        //Given an initial patient and notes list
        PatientBean patient = getPatientUpper30();
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 1);


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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 3);

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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 6);

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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 8);

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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 2);

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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 4);

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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 7);

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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 3);

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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 6);

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
        List<NoteBean> patientNotes = createNotes(patient.getPatientId(), 8);

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

    private List<NoteBean> createNotes(Integer patientId, Integer nbrOfTriggers) {
        var terms = AllTriggerTerms.TRIGGER_TERMS;
        List<NoteBean> noteList = new ArrayList<>();

        if (nbrOfTriggers < 0 || nbrOfTriggers > terms.size()) {
            throw new RuntimeException("Problem with the number of terms requested.");
        }
        for (int i = 0; i < nbrOfTriggers; i++) {
//            NoteBean note = new NoteBean("123" + i, patientId, terms.get((terms.size()%i), new Date()); todo frank
            NoteBean note = new NoteBean("123" + i, patientId.toString(), terms.get(i), new Date());
            noteList.add(note);
        }
        return noteList;

    }
}