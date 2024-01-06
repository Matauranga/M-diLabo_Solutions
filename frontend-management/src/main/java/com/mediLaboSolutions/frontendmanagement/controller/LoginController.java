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
    private final FrontController frontController;

    public LoginController(MSGateWay msGateWay, AuthService authService, FrontController frontController) {
        this.msGateWay = msGateWay;
        this.authService = authService;
        this.frontController = frontController;
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
            return frontController.home(model);

        } catch (Exception e) {
            log.error(e.getMessage());

            return login(model); //todo gerer err
        }
    }


//TODO gerer le logout

//    @PostMapping("/logout")
//    public void logout(Model model) {
//        msGateWay.logout();
//
//        //  return login(model);
//    }

}
