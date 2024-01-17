package com.mediLaboSolutions.backendriskassessment.DTO;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mediLaboSolutions.backendriskassessment.constants.TermsRiskAssessmentResults.IN_DANGER;
import static com.mediLaboSolutions.backendriskassessment.constants.TermsRiskAssessmentResults.NONE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AssessmentResultDTOTest {

    @Test
    public void testConstructorsAndGettersSetters() {
        AssessmentResultDTO riskResult = new AssessmentResultDTO();
        assertThat(riskResult).isNotNull();

        riskResult = new AssessmentResultDTO(NONE);
        assertThat(riskResult.getResult()).isEqualTo(NONE);

        riskResult.setResult(IN_DANGER);
        assertThat(riskResult.getResult()).isEqualTo(IN_DANGER);
    }
}