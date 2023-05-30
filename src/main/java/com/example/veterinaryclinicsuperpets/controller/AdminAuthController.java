package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.security.AuthenticationRequest;
import com.example.veterinaryclinicsuperpets.security.AuthenticationResponse;
import com.example.veterinaryclinicsuperpets.security.AuthenticationService;
import com.example.veterinaryclinicsuperpets.security.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/auth")
@RequiredArgsConstructor
public class AdminAuthController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
