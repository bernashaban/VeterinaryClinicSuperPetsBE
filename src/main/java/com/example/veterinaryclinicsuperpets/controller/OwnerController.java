package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.common.UserConstant;
import com.example.veterinaryclinicsuperpets.dto.user.UserRequest;
import com.example.veterinaryclinicsuperpets.dto.user.UserResponse;
import com.example.veterinaryclinicsuperpets.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class OwnerController {
  private final UserService userService;

  @GetMapping("id/{id}")
  public UserResponse getById(@PathVariable Long id) {
    return userService.getById(id);
  }

  @GetMapping("/{username}")
  public UserResponse getByUsername(@PathVariable String username) {
    return userService.getByUsername(username);
  }

  @GetMapping()
  public List<UserResponse> getAll() {
    return userService.getAll();
  }

  @GetMapping("/roles")
  public List<String> getAllRoles() {
    List<String> roles = new ArrayList<>();
    roles.add(UserConstant.DEFAULT_ROLE);
    roles.add("ROLE_VET");
    roles.add("ROLE_ADMIN");
    return roles;
  }

  @DeleteMapping("id/{id}")
  public UserResponse deleteById(@PathVariable Long id) {
    return userService.delete(id);
  }
  @DeleteMapping("/{username}")
  public UserResponse deleteByUsername(@PathVariable Long username) {
    return userService.delete(username);
  }

  @PostMapping()
  public Long register(@RequestBody UserRequest request) {
    return userService.create(request);
  }

  @PutMapping(value = "/{id}")
  public UserResponse update(@RequestBody UserRequest request, @PathVariable Long id) {
    try {
      return userService.update(request, id);
    } catch (ValidationException e) {
      // throw new RuntimeException(e);
      // log an error
      return null;
    }
  }

}
