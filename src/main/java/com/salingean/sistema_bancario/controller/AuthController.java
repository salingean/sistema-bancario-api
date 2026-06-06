package com.salingean.sistema_bancario.controller;

import com.salingean.sistema_bancario.service.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    // simplificado
    @PostMapping("/login")
    public  String login(@RequestParam String username, @RequestParam String password){
        if (username.equals("admin") && password.equals("123")) {
            return jwtService.generateToken(username);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
