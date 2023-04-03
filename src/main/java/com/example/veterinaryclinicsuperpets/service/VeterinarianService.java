package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianRequest;
import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianResponse;

import java.util.List;

public interface VeterinarianService {
  VeterinarianResponse getById(Long id);

  Long create(VeterinarianRequest request);

  VeterinarianResponse delete(Long id);

  VeterinarianResponse update(VeterinarianRequest request, Long id);

  List<VeterinarianResponse> getAll();
}
