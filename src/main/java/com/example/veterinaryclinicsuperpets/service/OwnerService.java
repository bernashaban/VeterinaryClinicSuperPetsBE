package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.owner.OwnerRequest;
import com.example.veterinaryclinicsuperpets.dto.owner.OwnerResponse;

import java.util.List;

public interface OwnerService {
    OwnerResponse getById(Long id);

    Long create(OwnerRequest request);

    OwnerResponse delete(Long id);

    OwnerResponse update(OwnerRequest request, Long id);

    List<OwnerResponse> getAll();
}
