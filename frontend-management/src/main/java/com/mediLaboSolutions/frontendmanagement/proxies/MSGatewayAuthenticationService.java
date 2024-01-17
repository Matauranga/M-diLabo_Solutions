package com.mediLaboSolutions.frontendmanagement.proxies;

import com.mediLaboSolutions.frontendmanagement.DTO.AuthRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Feign client interface for communicating with the Authentication Service through the Gateway.
 */
@FeignClient(name = "MS-GATEWAY")
public interface MSGatewayAuthenticationService {

    /**
     * Sends a login request to the Authentication Service.
     *
     * @param authRequest the authentication request DTO
     * @return the authentication token
     */
    @PostMapping(value = "/auth/login")
    String login(@Valid AuthRequest authRequest);

}
