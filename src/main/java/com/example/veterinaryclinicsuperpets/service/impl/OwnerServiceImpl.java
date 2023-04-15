package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.owner.OwnerRequest;
import com.example.veterinaryclinicsuperpets.dto.owner.OwnerResponse;
import com.example.veterinaryclinicsuperpets.entity.Owner;
import com.example.veterinaryclinicsuperpets.mapper.OwnerMapper;
import com.example.veterinaryclinicsuperpets.repository.OwnerRepository;
import com.example.veterinaryclinicsuperpets.service.OwnerService;
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
    if (request.getAddress().equals(owner.getAddress())) {
      owner.setAddress(request.getAddress());
    }
    if (!request.getEmail().equals(owner.getEmail())) {
      owner.setEmail(request.getEmail());
    }
    if (!request.getUsername().equals(owner.getUsername())) {
      owner.setUsername(request.getUsername());
    }
    if (!request.getPassword().equals(owner.getPassword())) {
      owner.setPassword(request.getPassword());
    }
    if (!request.getPhoneNum().equals(owner.getPhoneNum())) {
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
