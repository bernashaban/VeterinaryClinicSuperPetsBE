package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianRequest;
import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianResponse;

import javax.validation.ValidationException;
import java.util.List;

public interface VeterinarianService {
  VeterinarianResponse getById(Long id);

  Long create(VeterinarianRequest request) throws ValidationException;

  VeterinarianResponse delete(Long id);

  VeterinarianResponse update(VeterinarianRequest request, Long id) throws ValidationException;

  List<VeterinarianResponse> getAll();
}
