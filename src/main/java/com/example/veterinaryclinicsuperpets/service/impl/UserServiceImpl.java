package com.example.veterinaryclinicsuperpets.service.impl;
import com.example.veterinaryclinicsuperpets.dto.user.UserRequest;
import com.example.veterinaryclinicsuperpets.dto.user.UserResponse;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.mapper.UserMapper;
import com.example.veterinaryclinicsuperpets.repository.UserRepository;
import com.example.veterinaryclinicsuperpets.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final BCryptPasswordEncoder passwordEncoder;

  @Override
  public UserResponse getById(Long id) {
    User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return userMapper.entityToResponse(user);
  }

  @Override
  public UserResponse getByUsername(String username) {
    User user = userRepository.findByUsername(username).orElse(null);
    return userMapper.entityToResponse(user);
  }
  private boolean uniqueValidation(UserRequest request){
      User user = userRepository.findByEmail(request.getEmail()).orElse(null);
      User user2 = userRepository.findByUsername(request.getUsername()).orElse(null);
      User user3 = userRepository.findByPhoneNum(request.getPhoneNum()).orElse(null);
      return user == null && user2 == null && user3 == null;
  }
 @Override
  public Long create(UserRequest request) {
      if(uniqueValidation(request)){
          User user4 = userMapper.requestToEntity(request);
          return userRepository.save(user4).getId();
      }else{
          throw new IllegalArgumentException("The data is not unique!");
      }
  }

  @Override
  public UserResponse delete(Long id) {
    User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    userRepository.delete(user);
    return userMapper.entityToResponse(user);
  }

  @Override
  public UserResponse update(UserRequest request, String username) throws ValidationException {
    User user = userRepository.findByUsername(username).orElseThrow(IllegalArgumentException::new);
    if (request.getFullName() != null
        && !request.getFullName().equals(user.getFullName())) {
      user.setFullName(request.getFullName());
    }
    if (request.getAddress() != null
        && !request.getAddress().equals(user.getAddress())) {
      user.setAddress(request.getAddress());
    }
    if (request.getEmail() != null
        && !request.getEmail().equals(user.getEmail())) {
        User user1 = userRepository.findByEmail(request.getEmail()).orElse(null);
        if(user1!=null){
            throw new IllegalArgumentException("The data is not unique!");
        }else{
            user.setEmail(request.getEmail());
        }
    }
    if (request.getUsername() != null
        && !request.getUsername().equals(user.getUsername())) {
        User user1 = userRepository.findByUsername(request.getUsername()).orElse(null);
        if(user1!=null){
            throw new IllegalArgumentException("The data is not unique!");
        }else{
            user.setUsername(request.getUsername());
        }
      user.setUsername(request.getUsername());
    }
    if (request.getPassword() != null
        && !request.getPassword().equals(user.getPassword())) {

      String encryptedPwd = passwordEncoder.encode(request.getPassword());
            user.setPassword(encryptedPwd);
    }
    if (request.getPhoneNum() != null
        && !request.getPhoneNum().equals(user.getPhoneNum())) {
        User user1 = userRepository.findByPhoneNum(request.getPhoneNum()).orElse(null);
        if(user1!=null){
            throw new IllegalArgumentException("The data is not unique!");
        }else{
            user.setPhoneNum(request.getPhoneNum());
        }
      user.setPhoneNum(request.getPhoneNum());
    }
    if (request.getRoles() != null
        && !request.getRoles().equals(user.getRoles())) {
      user.setRoles(request.getRoles());
    }
    if (!(request.isActive() == user.isActive())) {
      user.setActive(request.isActive());
    }
      if (request.getPhotoUrl() != null
              && !request.getPhotoUrl().equals(user.getFullName())) {
          user.setPhotoUrl(request.getPhotoUrl());
      }
      if (request.getUniversityInfo() != null
              && !request.getUniversityInfo().equals(user.getFullName())) {
          user.setUniversityInfo(request.getUniversityInfo());
      }
      if (request.getSpeciality() != null
              && !request.getSpeciality().equals(user.getFullName())) {
          user.setSpeciality(request.getSpeciality());
      }
      if (request.getBirthDate() != null
              && !request.getBirthDate().equals(user.getFullName())) {
          LocalDate localDate = LocalDate.parse(request.getBirthDate());
          user.setBirthDate(localDate);
      }
    userRepository.save(user);
    return userMapper.entityToResponse(user);
  }

  @Override
  public List<UserResponse> getAll() {
    List<User> users = userRepository.findAll();
    return userMapper.listOfEntitiesToListOfResponses(users);
  }

  @Override
  public List<UserResponse> getAllVets() {
    List<User> users = userRepository.findAll();
    List<User> vets = new ArrayList<>();
    for (User user : users) {
      if (user.getRoles().equals("ROLE_VET")) {
        vets.add(user);
      }
    }
    return userMapper.listOfEntitiesToListOfResponses(vets);
  }
}
