package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianRequest;
import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianResponse;
import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.Veterinarian;
import com.example.veterinaryclinicsuperpets.mapper.VeterinarianMapper;
import com.example.veterinaryclinicsuperpets.repository.VeterinarianRepository;
import com.example.veterinaryclinicsuperpets.service.VeterinarianService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarianServiceImpl implements VeterinarianService {
  private final VeterinarianRepository veterinarianRepository;
  private final VeterinarianMapper veterinarianMapper;

  @Override
  public VeterinarianResponse getById(Long id) {
    Veterinarian veterinarian =
        veterinarianRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return veterinarianMapper.entityToResponse(veterinarian);
  }

  @Override
  public Long create(VeterinarianRequest request) {
    Veterinarian veterinarian = veterinarianMapper.requestToEntity(request);
    return veterinarianRepository.save(veterinarian).getId();
  }

  @Override
  public VeterinarianResponse delete(Long id) {
    Veterinarian veterinarian =
        veterinarianRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    veterinarianRepository.delete(veterinarian);
    return veterinarianMapper.entityToResponse(veterinarian);
  }

  @Override
  public VeterinarianResponse update(VeterinarianRequest request, Long id) {
    Veterinarian vet =
        veterinarianRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    if (!request.getFullName().equals(vet.getFullName())) {
      vet.setFullName(request.getFullName());
    }
    if (request.getEmail().equals(vet.getEmail())) {
      vet.setEmail(request.getEmail());
    }
    if (!request.getBirthDate().equals(vet.getBirthDate())) {
      vet.setBirthDate(request.getBirthDate());
    }
    if (!request.getSpeciality().equals(vet.getSpeciality())) {
      vet.setSpeciality(request.getSpeciality());
    }
    if (!request.getPhotoUrl().equals(vet.getPhotoUrl())) {
      vet.setPhotoUrl(request.getPhotoUrl());
    }
    if (!request.getUniversityInfo().equals(vet.getUniversityInfo())) {
      vet.setUniversityInfo(request.getUniversityInfo());
    }
    if (!request.getUsername().equals(vet.getUsername())) {
      vet.setUsername(request.getUsername());
    }
    if (!request.getPassword().equals(vet.getPassword())) {
      vet.setPassword(request.getPassword());
    }
    return veterinarianMapper.entityToResponse(vet);
  }

  @Override
  public List<VeterinarianResponse> getAll() {
    List<Veterinarian> veterinarians = (List<Veterinarian>) veterinarianRepository.findAll();
    return veterinarianMapper.listOfEntitiesToListOfResponses(veterinarians);
  }
}
