package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;

import java.util.List;

public interface PetService {
  PetResponse getById(Long id);

  Long create(PetRequest request);

  PetResponse delete(Long id);

  PetResponse update(PetRequest request, Long id);

  List<PetResponse> getAll();
  List<PetResponse> getAllByOwner(Long ownerId);
}
