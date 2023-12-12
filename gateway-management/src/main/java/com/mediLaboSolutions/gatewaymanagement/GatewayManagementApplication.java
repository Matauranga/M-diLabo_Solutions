package com.mediLaboSolutions.gatewaymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayManagementApplication.class, args);
    }

}
//TODO : mettre en place la gateaway