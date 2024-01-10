package com.mediLaboSolutions.backendriskassessment.services;

import com.mediLaboSolutions.backendriskassessment.DTO.AssessmentResultDTO;
import com.mediLaboSolutions.backendriskassessment.beans.NoteBean;
import com.mediLaboSolutions.backendriskassessment.beans.PatientBean;
import com.mediLaboSolutions.backendriskassessment.proxies.MSBackendNote;
import com.mediLaboSolutions.backendriskassessment.proxies.MSBackendPatientManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

import static com.mediLaboSolutions.backendriskassessment.constants.AllTriggerTerms.triggerTerms;
import static com.mediLaboSolutions.backendriskassessment.constants.TermsRiskAssessmentResults.*;

@Slf4j
@Service
public class AssessmentRiskServiceImpl implements AssessmentRiskService {

    private final MSBackendPatientManagement msBackendPatientManagement;

    private final MSBackendNote msBackendNote;

    public AssessmentRiskServiceImpl(MSBackendPatientManagement msBackendPatientManagement, MSBackendNote msBackendNote) {
        this.msBackendPatientManagement = msBackendPatientManagement;
        this.msBackendNote = msBackendNote;
    }

    private PatientBean getPatient(Integer id) {
        return msBackendPatientManagement.patientInfos(id);
    }


    private Boolean wordIsPresent(String word, List<NoteBean> noteBeanList) {
        return noteBeanList.stream().anyMatch(noteBean -> noteBean.getContent().toLowerCase(Locale.ROOT).contains(word.toLowerCase()));
    }

    private Integer getRiskScore(String id) {
        List<NoteBean> patientNotesList = msBackendNote.getPatientNotes(id);
        return triggerTerms.stream().filter(mot -> wordIsPresent(mot, patientNotesList)).toList().size();
    }

    public AssessmentResultDTO getRiskAssessmentResult(Integer patientId) {

        PatientBean patient = getPatient(patientId);
        Integer riskScore = getRiskScore(patientId.toString());
        log.info("Genre patient = {}", patient.getGender());
        log.info("Age patient = {}", patient.getAge());
        log.info("risk score = {}", riskScore);

        if (riskScore < 2) {
            return new AssessmentResultDTO(NONE);

        } else if (!patient.isUnder30YearsOld()) { // +30ans
            return switch (riskScore) {
                case 2, 3, 4, 5 -> new AssessmentResultDTO(BORDERLINE);
                case 6, 7 -> new AssessmentResultDTO(IN_DANGER);
                default -> new AssessmentResultDTO(EARLY_ONSET); // si plus de 8
            };
        } else if (patient.isMale()) {             // -30ans + homme
            return switch (riskScore) {
                case 2 -> new AssessmentResultDTO(NONE);
                case 3, 4 -> new AssessmentResultDTO(IN_DANGER);
                default -> new AssessmentResultDTO(EARLY_ONSET); // si plus de 5
            };
        } else {                                   // -30ans + femme
            return switch (riskScore) {
                case 2, 3 -> new AssessmentResultDTO(NONE);
                case 4, 5, 6 -> new AssessmentResultDTO(IN_DANGER);
                default -> new AssessmentResultDTO(EARLY_ONSET);// si plus de 7
            };
        }
    }
}
