package com.example.veterinaryclinicsuperpets.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping()
    public ResponseEntity<String> logout(HttpSession session) {
        // Invalidate the session and clear session attributes
        session.invalidate();
        return ResponseEntity.ok("Logout successful");
    }
}
