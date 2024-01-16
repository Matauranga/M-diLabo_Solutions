package com.mediLaboSolutions.frontendmanagement.beans;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RiskAssessmentBeanTest {

    @Test
    public void testConstructorsAndGettersSetters() {
        RiskAssessmentBean riskResult = new RiskAssessmentBean();
        assertThat(riskResult).isNotNull();

        riskResult = new RiskAssessmentBean("Result_Initial");

        riskResult.setResult("Result_Change");

        assertThat(riskResult.getResult()).isEqualTo("Result_Change");

    }

}