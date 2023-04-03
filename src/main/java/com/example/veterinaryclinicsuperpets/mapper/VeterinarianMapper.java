package com.example.veterinaryclinicsuperpets.mapper;

import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianRequest;
import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianResponse;
import com.example.veterinaryclinicsuperpets.entity.Veterinarian;

import java.util.List;

public interface VeterinarianMapper {
  VeterinarianResponse entityToResponse(Veterinarian entity);

  Veterinarian requestToEntity(VeterinarianRequest entityRequest);

  List<VeterinarianResponse> listOfEntitiesToListOfResponses(List<Veterinarian> entities);
}
