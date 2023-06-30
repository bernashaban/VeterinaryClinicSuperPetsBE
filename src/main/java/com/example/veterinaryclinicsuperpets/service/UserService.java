package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.user.UserRequest;
import com.example.veterinaryclinicsuperpets.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse getById(Long id);

    Long create(UserRequest request);

    UserResponse delete(Long id);

    UserResponse update(UserRequest request, Long id);

    List<UserResponse> getAll();
    List<UserResponse> getAllVets();

    UserResponse getByUsername(String username);
}
