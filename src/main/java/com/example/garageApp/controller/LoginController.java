package com.example.garageApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<String> login(Authentication authentication) {
    	System.out.println("you re connected");
        return ResponseEntity.ok("Hello, " + authentication.getName() + "!");
    }
}