package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;
import com.example.veterinaryclinicsuperpets.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {
    @Override
    public PetResponse getById(Long id) {
        return null;
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
