package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;
import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.mapper.PetMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PetMapperImpl implements PetMapper {
  private final String MALE_ABBREVIATION = "М";
  private final String FEMALE_ABBREVIATION = "Ж";
  private final String CAT_ABBREVIATION = "КОТКА";
  private final String DOG_ABBREVIATION = "КУЧЕ";
  private final String RABBIT_ABBREVIATION = "ЗАЕК";
  private final String OTHER_ABBREVIATION = "ДРУГИ";
  @Override
  public PetResponse entityToResponse(Pet entity) {
    PetResponse petResponse = new PetResponse();
    petResponse.setId(entity.getId());
    petResponse.setAge(entity.getAge());
    petResponse.setName(entity.getName());
    petResponse.setOwner(entity.getOwner());
    petResponse.setType(entity.getType());
    return petResponse;
  }

  @Override
  public Pet requestToEntity(PetRequest entityRequest) {
    Pet pet = new Pet();
    pet.setAge(entityRequest.getAge());
    pet.setName(entityRequest.getName());
    pet.setOwner(entityRequest.getOwner());
    pet.setType(entityRequest.getType());
    return pet;
  }

  @Override
  public List<PetResponse> listOfEntitiesToListOfResponses(List<Pet> entities) {
    return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
  }
}
