package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
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
    return null;
  }

  @Override
  public PetResponse delete(Long id) {
    return null;
  }

  @Override
  public PetResponse update(PetRequest request, Long id) {
    return null;
  }

  @Override
  public List<PetResponse> getAll() {
    return null;
  }
}
