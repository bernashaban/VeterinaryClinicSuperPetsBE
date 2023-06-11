package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl {

  private final UserRepository userRepository;
//  private final OwnerMapper ownerMapper;
//  private final Validator validator;
//
//  @Override
  public User getById(Long id) {
    User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return user;
            //ownerMapper.entityToResponse(owner);
  }
//
//  @Override
//  public Long create(OwnerRequest request) {
////    if (!Validator.validateEmail(request.getEmail())) {
////      throw new IllegalArgumentException("Email is not valid!");
////    }
////    if (!Validator.validatePhoneNum(request.getPhoneNum())) {
////      throw new IllegalArgumentException("Phone number is not valid! Should start whit '+359'");
////    }
////    if (!Validator.validateUsername(request.getUsername())) {
////      throw new IllegalArgumentException("Username is not valid!");
////    }
////    if (!Validator.validatePassword(request.getPassword())) {
////      throw new IllegalArgumentException(
////          "Password is not valid! Minimum eight characters, at least one letter and one number.");
////    }
//    Owner owner = ownerMapper.requestToEntity(request);
//    return ownerRepository.save(owner).getId();
//  }
//
//  @Override
//  public OwnerResponse delete(Long id) {
//    Owner owner = ownerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
//    ownerRepository.delete(owner);
//    return ownerMapper.entityToResponse(owner);
//  }
//
//  @Override
//  public OwnerResponse update(OwnerRequest request, Long id) throws ValidationException {
//    Owner owner = ownerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
//    if (!request.getFullName().equals(owner.getFullName())) {
//      owner.setFullName(request.getFullName());
//    }
//    if (!request.getAddress().equals(owner.getAddress())) {
//      owner.setAddress(request.getAddress());
//    }
//    if (!request.getEmail().equals(owner.getEmail())) {
//      if (!validator.validateEmail(request.getEmail())) {
//        throw new IllegalArgumentException("Email is not valid!");
//      }
//      owner.setEmail(request.getEmail());
//    }
//    if (!request.getUsername().equals(owner.getUsername())) {
//      if (!validator.validateUsername(request.getUsername())) {
//        throw new IllegalArgumentException("Username is not valid!");
//      }
//      owner.setUsername(request.getUsername());
//    }
//    if (!request.getPassword().equals(owner.getPassword())) {
//      if (!validator.validatePassword(request.getPassword())) {
//        throw new IllegalArgumentException(
//            "Password is not valid! Minimum eight characters, at least one letter and one number.");
//      }
//      owner.setPassword(request.getPassword());
//    }
//    if (!request.getPhoneNum().equals(owner.getPhoneNum())) {
//      if (!validator.validatePhoneNum(request.getPhoneNum())) {
//        throw new IllegalArgumentException("Phone number is not valid! Should start whit '+359'");
//      }
//      owner.setPhoneNum(request.getPhoneNum());
//    }
//    return ownerMapper.entityToResponse(owner);
//  }
//
//  @Override
  public List<User> getAllVets() {
    List<User> vets = userRepository.findAll();
    return vets.stream().filter(user -> user.getRoles().contains("ROLE_VET"))
            .filter(user -> user.getRoles().split(",").length==2).collect(Collectors.toList());
  }

    public List<User> getAllOwners() {
        List<User> owners = userRepository.findAll();
        return owners.stream().filter(user -> user.getRoles().contains("ROLE_OWNER"))
                .filter(user -> user.getRoles().length()==1).collect(Collectors.toList());
    }

}
