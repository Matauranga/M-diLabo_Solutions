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

    /**
     * Handles GET requests for the login page.
     *
     * @param model the Spring MVC model
     * @return the logical view name for the login page
     */
    @GetMapping({"/", "/signin"})
    public String login(Model model) {
        model.addAttribute("authRequest", new AuthRequest());
        return "login";
    }

    /**
     * Handles POST requests for user authentication and redirects to the patient page on success.
     *
     * @param authRequest the authentication request data
     * @param model       the Spring MVC model
     * @return the logical view name for redirecting to the patient page or the login page on failure
     */
    @PostMapping("/signin")
    public String signin(AuthRequest authRequest, Model model) {
        try {
            final String token = msGateWay.login(authRequest);
            authService.saveToken(token);
            return "redirect:/patients";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "redirect:/";
        }
    }

    /**
     * Handles POST requests for user logout and redirects to the login page.
     *
     * @param model the Spring MVC model
     * @return the logical view name for redirecting to the login page
     */
    @PostMapping("/logout")
    public String logout(Model model) {
        authService.logout();
        return "redirect:/";
    }

}
