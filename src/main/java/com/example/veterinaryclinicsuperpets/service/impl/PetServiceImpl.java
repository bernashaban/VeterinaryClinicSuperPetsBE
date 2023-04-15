package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;
import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.mapper.PetMapper;
import com.example.veterinaryclinicsuperpets.repository.PetRepository;
import com.example.veterinaryclinicsuperpets.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {
  private final PetRepository petRepository;
  private final PetMapper petMapper;

  @Override
  public PetResponse getById(Long id) {
    Pet pet = petRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return petMapper.entityToResponse(pet);
  }

  @Override
  public Long create(PetRequest request) {
    Pet pet = petMapper.requestToEntity(request);
    return petRepository.save(pet).getId();
  }

  @Override
  public PetResponse delete(Long id) {
    Pet pet = petRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    petRepository.delete(pet);
    return petMapper.entityToResponse(pet);
  }

  @Override
  public PetResponse update(PetRequest request, Long id) {
    Pet pet = petRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    if (!request.getName().equals(pet.getName())) {
      pet.setName(request.getName());
    }
    if (request.getAge() != pet.getAge()) {
      pet.setAge(request.getAge());
    }
    if (!request.getOwner().equals(pet.getOwner())) {
      pet.setOwner(request.getOwner());
    }
    if (!request.getType().equals(pet.getType())) {
      pet.setType(request.getType());
    }
    return petMapper.entityToResponse(pet);
  }

  @Override
  public List<PetResponse> getAll() {
    List<Pet> pets = (List<Pet>) petRepository.findAll();
    return petMapper.listOfEntitiesToListOfResponses(pets);
  }
}
