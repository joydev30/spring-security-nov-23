package com.authenticatedBackend.controller;

import com.authenticatedBackend.model.LoginResponseDTO;
import com.authenticatedBackend.model.User;
//import com.authenticatedBackend.model.LoginResponseDTO;
import com.authenticatedBackend.model.RegistrationDTO;
import com.authenticatedBackend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO body){
        System.out.println("Inside controller");
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}   
