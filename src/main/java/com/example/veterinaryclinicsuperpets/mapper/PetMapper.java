package com.example.veterinaryclinicsuperpets.mapper;

import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;
import com.example.veterinaryclinicsuperpets.entity.Pet;

import java.util.List;

public interface PetMapper {
  PetResponse entityToResponse(Pet entity);

  Pet requestToEntity(PetRequest entityRequest);

  List<PetResponse> listOfEntitiesToListOfResponses(List<Pet> entities);
}
