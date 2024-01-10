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

@Slf4j
@Service
public class AssessmentRiskServiceImpl implements AssessmentRiskService {
    private static final List<String> triggerTerms = List.of("Hémoglobine A1C", "Microalbumine", "Taille",
            "Poids", "Fume", "Anormal", "Cholestérol", "Vertiges", "Rechute", "Réaction", "Anticorps"); //TODO comprendre la liste des mots à fournir

    private final MSBackendPatientManagement msBackendPatientManagement;

    private final MSBackendNote msBackendNote;

    public AssessmentRiskServiceImpl(MSBackendPatientManagement msBackendPatientManagement, MSBackendNote msBackendNote) {
        this.msBackendPatientManagement = msBackendPatientManagement;
        this.msBackendNote = msBackendNote;
    }

    private PatientBean getPatient(Integer id) {
        return msBackendPatientManagement.patientInfos(id);
    }

    private List<NoteBean> getAllPatientNotes(String id) {
        return msBackendNote.getPatientNotes(id);
    }

    private Boolean wordIsPresent(String word, List<NoteBean> noteBeanList) {
        return noteBeanList.stream().anyMatch(noteBean -> noteBean.getContent().toLowerCase(Locale.ROOT).contains(word.toLowerCase()));
    }

    private Integer getRiskScore(String id) {
        return triggerTerms.stream().filter(mot -> wordIsPresent(mot, getAllPatientNotes(id))).toList().size();
    }


    public AssessmentResultDTO getResult(Integer patientId) {

        PatientBean patient = getPatient(patientId);
        Integer riskScore = getRiskScore(patientId.toString());
        log.info("Genre patient = {}", patient.getGender());
        log.info("Age patient = {}", patient.getAge());
        log.info("risk score = {}", riskScore);

        if (riskScore <= 1) {
            return new AssessmentResultDTO("None");
        }


        if (!patient.isUnder30YearsOld() && riskScore > 1 && riskScore < 6) {
            return new AssessmentResultDTO("Borderline");
        }


        if (!patient.isUnder30YearsOld() && 5 > riskScore && riskScore < 8) {
            return new AssessmentResultDTO("InDanger");
        }

        if (patient.isMale() && patient.isUnder30YearsOld() && riskScore > 2 && riskScore < 5) {
            return new AssessmentResultDTO("InDanger");
        }

        if (!patient.isMale() && patient.isUnder30YearsOld() && riskScore > 3 && riskScore < 7) {
            return new AssessmentResultDTO("InDanger");
        }


        if (!patient.isUnder30YearsOld() && riskScore > 7) {
            return new AssessmentResultDTO("EarlyOnset");
        }

        if (patient.isMale() && patient.isUnder30YearsOld() && riskScore > 4) {
            return new AssessmentResultDTO("EarlyOnset");
        }

        if (!patient.isMale() && patient.isUnder30YearsOld() && riskScore > 6) {
            return new AssessmentResultDTO("EarlyOnset");
        }


        return new AssessmentResultDTO("Problem");
    }


    public AssessmentResultDTO getResult2(Integer patientId) {

        PatientBean patient = getPatient(patientId);
        Integer riskScore = getRiskScore(patientId.toString());
        log.info("Genre patient = {}", patient.getGender());
        log.info("Age patient = {}", patient.getAge());
        log.info("risk score = {}", riskScore);

        if (riskScore - 1 <= 1) {
            return new AssessmentResultDTO("None");

        } else if (!patient.isUnder30YearsOld()) { // +30ans
            return switch (riskScore - 1) {
                case 2, 3, 4 -> new AssessmentResultDTO("InDanger");// si 3 / 4 / 5 todo rajoutez 2 ?? donc 1 ici
                case 5, 6 -> new AssessmentResultDTO("Borderline"); // si 6 / 7
                default -> new AssessmentResultDTO("EarlyOnset"); // si plus de 8
            };

        } else if (patient.isMale()) { // -30ans + homme
            return switch (riskScore - 1) {
                case 2, 3 -> new AssessmentResultDTO("InDanger"); // si 3 / 4
                default -> new AssessmentResultDTO("EarlyOnset"); // si plus de 5
            };
        } else { // -30ans + femme
            return switch (riskScore - 1) {
                case 2 -> new AssessmentResultDTO("None"); // si 3
                case 3, 4, 5 -> new AssessmentResultDTO("InDanger");// si 4 / 5 / 6
                default -> new AssessmentResultDTO("EarlyOnset");// si plus de 7
            };
        }
    }
}
