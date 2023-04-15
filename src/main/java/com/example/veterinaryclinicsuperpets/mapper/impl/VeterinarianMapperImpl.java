package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianRequest;
import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianResponse;
import com.example.veterinaryclinicsuperpets.entity.Veterinarian;
import com.example.veterinaryclinicsuperpets.mapper.VeterinarianMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class VeterinarianMapperImpl implements VeterinarianMapper {
  @Override
  public VeterinarianResponse entityToResponse(Veterinarian entity) {
    VeterinarianResponse veterinarianResponse = new VeterinarianResponse();
    veterinarianResponse.setId(entity.getId());
    veterinarianResponse.setEmail(entity.getEmail());
    veterinarianResponse.setBirthDate(entity.getBirthDate());
    veterinarianResponse.setPassword(entity.getPassword());
    veterinarianResponse.setPhotoUrl(entity.getPhotoUrl());
    veterinarianResponse.setFullName(entity.getFullName());
    veterinarianResponse.setSpeciality(entity.getSpeciality());
    veterinarianResponse.setUsername(entity.getUsername());
    veterinarianResponse.setUniversityInfo(entity.getUniversityInfo());
    return veterinarianResponse;
  }

  @Override
  public Veterinarian requestToEntity(VeterinarianRequest entityRequest) {
    Veterinarian veterinarian = new Veterinarian();
    veterinarian.setEmail(entityRequest.getEmail());
    veterinarian.setBirthDate(entityRequest.getBirthDate());
    veterinarian.setPassword(entityRequest.getPassword());
    veterinarian.setPhotoUrl(entityRequest.getPhotoUrl());
    veterinarian.setFullName(entityRequest.getFullName());
    veterinarian.setSpeciality(entityRequest.getSpeciality());
    veterinarian.setUsername(entityRequest.getUsername());
    veterinarian.setUniversityInfo(entityRequest.getUniversityInfo());
    return veterinarian;
  }

  @Override
  public List<VeterinarianResponse> listOfEntitiesToListOfResponses(List<Veterinarian> entities) {
    return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
  }
}
