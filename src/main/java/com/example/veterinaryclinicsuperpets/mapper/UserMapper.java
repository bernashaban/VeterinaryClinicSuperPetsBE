package com.example.veterinaryclinicsuperpets.mapper;

import com.example.veterinaryclinicsuperpets.dto.user.UserRequest;
import com.example.veterinaryclinicsuperpets.dto.user.UserResponse;
import com.example.veterinaryclinicsuperpets.entity.User;

import java.util.List;

public interface UserMapper {
  UserResponse entityToResponse(User entity);
  UserResponse entityToOwner(User entity);
  User requestToEntity(UserRequest entityRequest);


  List<UserResponse> listOfEntitiesToListOfResponses(List<User> entities);
}
