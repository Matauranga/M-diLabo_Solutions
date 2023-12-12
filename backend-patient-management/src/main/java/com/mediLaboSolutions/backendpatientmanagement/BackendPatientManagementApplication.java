package com.mediLaboSolutions.backendpatientmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BackendPatientManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendPatientManagementApplication.class, args);
    }

}