package com.mediLaboSolutions.backendriskassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.mediLaboSolutions.backendriskassessment")
@EnableDiscoveryClient
public class BackendRiskAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendRiskAssessmentApplication.class, args);
	}

}
