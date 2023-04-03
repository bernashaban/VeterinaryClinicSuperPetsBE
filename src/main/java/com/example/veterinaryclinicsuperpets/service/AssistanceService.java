package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceRequest;
import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceResponse;

import java.util.List;

public interface AssistanceService {
  AssistanceResponse getById(Long id);

  Long create(AssistanceRequest request);

  AssistanceResponse delete(Long id);

  AssistanceResponse update(AssistanceRequest request, Long id);

  List<AssistanceResponse> getAll();
}
