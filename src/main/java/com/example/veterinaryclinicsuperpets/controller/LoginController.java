package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.UserCredentials;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials, HttpSession session) {
        String username =   credentials.getUsername();
        String pass =   credentials.getPassword();

        Optional<User> optionalUser = repository.findByUsername(credentials.getUsername());

        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        User user = optionalUser.get();

        boolean passwordMatch = passwordEncoder.matches(credentials.getPassword(), user.getPassword());
        if (!passwordMatch) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        session.setAttribute("username", username);
        session.setAttribute("loggedIn", true);
        return ResponseEntity.ok("Login successful");
    }
}
