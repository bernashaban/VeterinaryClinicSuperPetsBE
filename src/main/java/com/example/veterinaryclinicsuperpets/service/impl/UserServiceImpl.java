package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.user.UserRequest;
import com.example.veterinaryclinicsuperpets.dto.user.UserResponse;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.mapper.UserMapper;
import com.example.veterinaryclinicsuperpets.repository.UserRepository;
import com.example.veterinaryclinicsuperpets.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final Validator validator;

  @Override
  public UserResponse getById(Long id) {
    User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return userMapper.entityToResponse(user);
  }

  @Override
  public UserResponse getByUsername(String username) {
    User user = userRepository.findByUsername(username).orElseThrow(IllegalArgumentException::new);
    return userMapper.entityToResponse(user);
  }

  @Override
  public Long create(UserRequest request) throws IllegalArgumentException {
    User user = userRepository.findByUsername(request.getUsername()).orElse(null);
    User user2 = userRepository.findByEmail(request.getEmail()).orElse(null);
    User user3 = userRepository.findByPhoneNum(request.getPhoneNum()).orElse(null);
    if(user!=null){
      throw new IllegalArgumentException("Username already exist!");
    }else if(user2!=null){
      throw new IllegalArgumentException("Email already exist!");
    }else if(user3!=null){
      throw new IllegalArgumentException("Phone number already exist!");
    }else{
      User user4 = userMapper.requestToEntity(request);
      return userRepository.save(user4).getId();
    }
    //    if (!Validator.validateEmail(request.getEmail())) {
    //      throw new IllegalArgumentException("Email is not valid!");
    //    }
    //    if (!Validator.validatePhoneNum(request.getPhoneNum())) {
    //      throw new IllegalArgumentException("Phone number is not valid! Should start whit
    // '+359'");
    //    }
    //    if (!Validator.validateUsername(request.getUsername())) {
    //      throw new IllegalArgumentException("Username is not valid!");
    //    }
    //    if (!Validator.validatePassword(request.getPassword())) {
    //      throw new IllegalArgumentException(
    //          "Password is not valid! Minimum eight characters, at least one letter and one
    // number.");
    //    }
  }

  @Override
  public UserResponse delete(Long id) {
    User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    userRepository.delete(user);
    return userMapper.entityToResponse(user);
  }

  @Override
  public UserResponse update(UserRequest request, Long id) throws ValidationException {
    User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    if (request.getFullName() != null && !request.getFullName().equals("")
            && !request.getFullName().equals(user.getFullName())
    ) {
      user.setFullName(request.getFullName());
    }
    if (request.getAddress() != null && !request.getFullName().equals("")
            && !request.getAddress().equals(user.getAddress())) {
      user.setAddress(request.getAddress());
    }
    if (request.getEmail() != null && !request.getFullName().equals("")
            && !request.getEmail().equals(user.getEmail())) {
      //      if (!validator.validateEmail(request.getEmail())) {
      //        throw new IllegalArgumentException("Email is not valid!");
      //      }
      user.setEmail(request.getEmail());
    }
    if (request.getUsername() != null && request.getFullName().equals("")
            && !request.getUsername().equals(user.getUsername())) {
      //      if (!validator.validateUsername(request.getUsername())) {
      //        throw new IllegalArgumentException("Username is not valid!");
      //      }
      user.setUsername(request.getUsername());
    }
    if (request.getPassword() != null && request.getFullName().equals("")
            && !request.getPassword().equals(user.getPassword())) {
      //      if (!validator.validatePassword(request.getPassword())) {
      //        throw new IllegalArgumentException(
      //            "Password is not valid! Minimum eight characters, at least one letter and one
      // number.");
      //      }
      user.setPassword(request.getPassword());
    }
    if (request.getPhoneNum() != null && request.getFullName().equals("")
            && !request.getPhoneNum().equals(user.getPhoneNum())) {
      //      if (!validator.validatePhoneNum(request.getPhoneNum())) {
      //        throw new IllegalArgumentException("Phone number is not valid! Should start whit
      // '+359'");
      //      }
      user.setPhoneNum(request.getPhoneNum());
    }
    if (request.getRoles() != null && request.getFullName().equals("")
            && !request.getRoles().equals(user.getRoles())) {
      user.setRoles(request.getRoles());
    }
    if (!(request.isActive() == user.isActive())) {
      user.setActive(request.isActive());
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
      if (user.getRoles().equals("ROLE_VET")){
        vets.add(user);
      }
//      List<String> roles = Arrays.stream(user.getRoles().split(",")).collect(Collectors.toList());
//      if (roles.contains("ROLE_VET")) {
//        vets.add(user);
//      }
    }
    return userMapper.listOfEntitiesToListOfResponses(vets);
  }
}
