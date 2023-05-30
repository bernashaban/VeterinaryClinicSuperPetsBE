package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianRequest;
import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianResponse;
import com.example.veterinaryclinicsuperpets.entity.Veterinarian;
import com.example.veterinaryclinicsuperpets.mapper.VeterinarianMapper;
import com.example.veterinaryclinicsuperpets.repository.VeterinarianRepository;
import com.example.veterinaryclinicsuperpets.service.VeterinarianService;
import com.example.veterinaryclinicsuperpets.util.validations.Validator;
import jakarta.xml.bind.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarianServiceImpl implements VeterinarianService {
  private final VeterinarianRepository veterinarianRepository;
  private final VeterinarianMapper veterinarianMapper;
  private final Validator validator;

  @Override
  public VeterinarianResponse getById(Long id) {
    Veterinarian veterinarian =
        veterinarianRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return veterinarianMapper.entityToResponse(veterinarian);
  }

  @Override
  public Long create(VeterinarianRequest request) throws ValidationException {
    if (!validator.validateEmail(request.getEmail())) {
      throw new IllegalArgumentException("Email is not valid!");
    }
    if (!validator.validateUsername(request.getUsername())) {
      throw new IllegalArgumentException("Username is not valid!");
    }
    if (!validator.validatePassword(request.getPassword())) {
      throw new IllegalArgumentException(
              "Password is not valid! Minimum eight characters, at least one letter and one number.");
    }
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
  public VeterinarianResponse update(VeterinarianRequest request, Long id) throws ValidationException {
    Veterinarian vet =
        veterinarianRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    if (!request.getFullName().equals(vet.getFullName())) {
      vet.setFullName(request.getFullName());
    }
    if (!request.getEmail().equals(vet.getEmail())) {
      if (!validator.validateEmail(request.getEmail())) {
        throw new IllegalArgumentException("Email is not valid!");
      }
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
      if (!validator.validateUsername(request.getUsername())) {
        throw new IllegalArgumentException("Username is not valid!");
      }
      vet.setUsername(request.getUsername());
    }
    if (!request.getPassword().equals(vet.getPassword())) {
      if (!validator.validatePassword(request.getPassword())) {
        throw new IllegalArgumentException(
                "Password is not valid! Minimum eight characters, at least one letter and one number.");
      }
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
