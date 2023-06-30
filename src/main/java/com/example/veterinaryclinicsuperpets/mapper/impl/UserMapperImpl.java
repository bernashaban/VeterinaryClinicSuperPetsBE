package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.common.UserConstant;
import com.example.veterinaryclinicsuperpets.dto.user.UserRequest;
import com.example.veterinaryclinicsuperpets.dto.user.UserResponse;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapperImpl implements UserMapper {
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public UserResponse entityToResponse(User entity) {
    UserResponse userResponse = getDuplicate(entity);
    userResponse.setPhotoUrl(entity.getPhotoUrl());
    userResponse.setSpeciality(entity.getSpeciality());
    userResponse.setBirthDate(entity.getBirthDate());
    userResponse.setUniversityInfo(entity.getUniversityInfo());
    return userResponse;
  }

  @Override
  public UserResponse entityToOwner(User entity) {
    return getDuplicate(entity);
  }

  private UserResponse getDuplicate(User entity) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(entity.getId());
    userResponse.setAddress(entity.getAddress());
    userResponse.setEmail(entity.getEmail());
    userResponse.setPassword(entity.getPassword());
    userResponse.setFullName(entity.getFullName());
    userResponse.setPhoneNum(entity.getPhoneNum());
    userResponse.setUsername(entity.getUsername());
    userResponse.setRoles(entity.getRoles());
    userResponse.setActive(entity.isActive());
    return userResponse;
  }

  @Override
  public User requestToEntity(UserRequest entityRequest) {
    User user = new User();
    user.setAddress(entityRequest.getAddress());
    user.setEmail(entityRequest.getEmail());
    user.setFullName(entityRequest.getFullName());
    String encryptedPwd = passwordEncoder.encode(entityRequest.getPassword());
    user.setPassword(encryptedPwd);
    user.setUsername(entityRequest.getUsername());
    user.setPhoneNum(entityRequest.getPhoneNum());
    user.setRoles(UserConstant.DEFAULT_ROLE);
    user.setActive(true);
    return user;
  }

  @Override
  public List<UserResponse> listOfEntitiesToListOfResponses(List<User> entities) {
    return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
  }
}
