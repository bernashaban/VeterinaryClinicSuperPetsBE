package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.dto.owner.OwnerRequest;
import com.example.veterinaryclinicsuperpets.dto.owner.OwnerResponse;
import com.example.veterinaryclinicsuperpets.entity.Owner;
import com.example.veterinaryclinicsuperpets.mapper.OwnerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OwnerMapperImpl implements OwnerMapper {
  @Override
  public OwnerResponse entityToResponse(Owner entity) {
    OwnerResponse ownerResponse = new OwnerResponse();
    ownerResponse.setId(entity.getId());
    ownerResponse.setAddress(entity.getAddress());
    ownerResponse.setEmail(entity.getEmail());
    ownerResponse.setPassword(entity.getPassword());
    ownerResponse.setFullName(entity.getFullName());
    ownerResponse.setPhoneNum(entity.getPhoneNum());
    ownerResponse.setUsername(entity.getUsername());
    return ownerResponse;
  }

  @Override
  public Owner requestToEntity(OwnerRequest entityRequest) {
    Owner owner = new Owner();
    owner.setAddress(entityRequest.getAddress());
    owner.setEmail(entityRequest.getEmail());
    owner.setFullName(entityRequest.getFullName());
    owner.setPassword(entityRequest.getPassword());
    owner.setUsername(entityRequest.getUsername());
    owner.setPhoneNum(entityRequest.getPhoneNum());
    return owner;
  }

  @Override
  public List<OwnerResponse> listOfEntitiesToListOfResponses(List<Owner> entities) {
    return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
  }
}
