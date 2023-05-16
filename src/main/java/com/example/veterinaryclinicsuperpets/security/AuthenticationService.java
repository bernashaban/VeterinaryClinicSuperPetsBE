package com.example.veterinaryclinicsuperpets.security;

import com.example.veterinaryclinicsuperpets.entity.Owner;
import com.example.veterinaryclinicsuperpets.entity.enums.Role;
import com.example.veterinaryclinicsuperpets.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final OwnerRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user =
        Owner.builder()
            .fullName(request.getFullName())
            .address(request.getAddress())
            .email(request.getEmail())
            .phoneNum(request.getPhoneNum())
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.OWNER)
            .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken).build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()));
    //todo throw the correct exception and dont forget to catch it
    var user = repository.findByUsername(request.getUsername()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken).build();
  }
}
