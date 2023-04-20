package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.owner.OwnerRequest;
import com.example.veterinaryclinicsuperpets.dto.owner.OwnerResponse;
import com.example.veterinaryclinicsuperpets.entity.Owner;
import com.example.veterinaryclinicsuperpets.mapper.OwnerMapper;
import com.example.veterinaryclinicsuperpets.repository.OwnerRepository;
import com.example.veterinaryclinicsuperpets.service.OwnerService;
import com.example.veterinaryclinicsuperpets.util.validations.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {
  private final OwnerRepository ownerRepository;
  private final OwnerMapper ownerMapper;

  @Override
  public OwnerResponse getById(Long id) {
    Owner owner = ownerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return ownerMapper.entityToResponse(owner);
  }

  @Override
  public Long create(OwnerRequest request) {
    if (!Validator.validateEmail(request.getEmail())) {
      throw new IllegalArgumentException("Email is not valid!");
    }
    if (!Validator.validatePhoneNum(request.getPhoneNum())) {
      throw new IllegalArgumentException("Phone number is not valid! Should start whit '+359'");
    }
    if (!Validator.validateUsername(request.getUsername())) {
      throw new IllegalArgumentException("Username is not valid!");
    }
    if (!Validator.validatePassword(request.getPassword())) {
      throw new IllegalArgumentException(
          "Password is not valid! Minimum eight characters, at least one letter and one number.");
    }
    Owner owner = ownerMapper.requestToEntity(request);
    return ownerRepository.save(owner).getId();
  }

  @Override
  public OwnerResponse delete(Long id) {
    Owner owner = ownerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    ownerRepository.delete(owner);
    return ownerMapper.entityToResponse(owner);
  }

  @Override
  public OwnerResponse update(OwnerRequest request, Long id) {
    Owner owner = ownerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    if (!request.getFullName().equals(owner.getFullName())) {
      owner.setFullName(request.getFullName());
    }
    if (!request.getAddress().equals(owner.getAddress())) {
      owner.setAddress(request.getAddress());
    }
    if (!request.getEmail().equals(owner.getEmail())) {
      if (!Validator.validateEmail(request.getEmail())) {
        throw new IllegalArgumentException("Email is not valid!");
      }
      owner.setEmail(request.getEmail());
    }
    if (!request.getUsername().equals(owner.getUsername())) {
      if (!Validator.validateUsername(request.getUsername())) {
        throw new IllegalArgumentException("Username is not valid!");
      }
      owner.setUsername(request.getUsername());
    }
    if (!request.getPassword().equals(owner.getPassword())) {
      if (!Validator.validatePassword(request.getPassword())) {
        throw new IllegalArgumentException(
            "Password is not valid! Minimum eight characters, at least one letter and one number.");
      }
      owner.setPassword(request.getPassword());
    }
    if (!request.getPhoneNum().equals(owner.getPhoneNum())) {
      if (!Validator.validatePhoneNum(request.getPhoneNum())) {
        throw new IllegalArgumentException("Phone number is not valid! Should start whit '+359'");
      }
      owner.setPhoneNum(request.getPhoneNum());
    }
    return ownerMapper.entityToResponse(owner);
  }

  @Override
  public List<OwnerResponse> getAll() {
    List<Owner> owners = (List<Owner>) ownerRepository.findAll();
    return ownerMapper.listOfEntitiesToListOfResponses(owners);
  }
}
