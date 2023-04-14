package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianRequest;
import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianResponse;
import com.example.veterinaryclinicsuperpets.service.VeterinarianService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarianServiceImpl implements VeterinarianService {
  @Override
  public VeterinarianResponse getById(Long id) {
    return null;
  }

  @Override
  public Long create(VeterinarianRequest request) {
    return null;
  }

  @Override
  public VeterinarianResponse delete(Long id) {
    return null;
  }

  @Override
  public VeterinarianResponse update(VeterinarianRequest request, Long id) {
    return null;
  }

  @Override
  public List<VeterinarianResponse> getAll() {
    return null;
  }
}
