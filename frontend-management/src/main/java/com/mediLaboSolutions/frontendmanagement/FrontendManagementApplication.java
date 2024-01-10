package com.mediLaboSolutions.frontendmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.mediLaboSolutions.frontendmanagement")
@EnableDiscoveryClient
public class FrontendManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendManagementApplication.class, args);
    }

}