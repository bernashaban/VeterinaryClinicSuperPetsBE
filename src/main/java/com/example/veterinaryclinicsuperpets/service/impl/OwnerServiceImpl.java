package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.owner.OwnerRequest;
import com.example.veterinaryclinicsuperpets.dto.owner.OwnerResponse;
import com.example.veterinaryclinicsuperpets.entity.Owner;
import com.example.veterinaryclinicsuperpets.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    @Override
    public OwnerResponse getById(Long id) {
        return null;
    }

    @Override
    public Long create(OwnerRequest request) {
        return null;
    }

    @Override
    public OwnerResponse delete(Long id) {
        return null;
    }

    @Override
    public OwnerResponse update(OwnerRequest request, Long id) {
        return null;
    }

    @Override
    public List<OwnerResponse> getAll() {
        return null;
    }
}
