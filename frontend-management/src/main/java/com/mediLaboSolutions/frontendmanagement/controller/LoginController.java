package com.mediLaboSolutions.frontendmanagement.controller;

import com.mediLaboSolutions.frontendmanagement.DTO.AuthRequest;
import com.mediLaboSolutions.frontendmanagement.proxies.AuthService;
import com.mediLaboSolutions.frontendmanagement.proxies.MSGateWay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {

    private final MSGateWay msGateWay;
    private final AuthService authService;
    private final PatientController patientController;

    public LoginController(MSGateWay msGateWay, AuthService authService, PatientController patientController) {
        this.msGateWay = msGateWay;
        this.authService = authService;
        this.patientController = patientController;
    }

    @GetMapping({"/", "/signin"})
    public String login(Model model) {
        model.addAttribute("authRequest", new AuthRequest());

        return "login";
    }

    @PostMapping("/signin")
    public String signin(AuthRequest authRequest, Model model) {
        try {
            final String token = msGateWay.login(authRequest);
            authService.saveToken(token);
            return patientController.patientList(model);

        } catch (Exception e) {
            log.error(e.getMessage());

            return login(model); //todo gerer err
        }
    }

    @PostMapping("/logout")
    public String logout(Model model) {
        authService.logout();

        return login(model);
    }

}
