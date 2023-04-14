package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceRequest;
import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceResponse;
import com.example.veterinaryclinicsuperpets.entity.Assistance;
import com.example.veterinaryclinicsuperpets.mapper.AssistanceMapper;
import com.example.veterinaryclinicsuperpets.repository.AssistanceRepository;
import com.example.veterinaryclinicsuperpets.service.AssistanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssistanceServiceImpl implements AssistanceService {

  private final AssistanceRepository assistanceRepository;
  private final AssistanceMapper assistanceMapper;

  @Override
  public AssistanceResponse getById(Long id) {
    Assistance assistance =
        assistanceRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return assistanceMapper.entityToResponse(assistance);
  }

  @Override
  public Long create(AssistanceRequest request) {
    Assistance assistance = assistanceMapper.requestToEntity(request);
    return assistanceRepository.save(assistance).getId();
  }

  @Override
  public AssistanceResponse delete(Long id) {
    Assistance assistance =
        assistanceRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    assistanceRepository.delete(assistance);
    return assistanceMapper.entityToResponse(assistance);
  }

  @Override
  public AssistanceResponse update(AssistanceRequest request, Long id) {
    Assistance assistance =
        assistanceRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    if (!request.getName().equals(assistance.getName())) {
      assistance.setName(request.getName());
    }
    if (request.getServiceType().equals(assistance.getServiceType())) {
      assistance.setServiceType(request.getServiceType());
    }
    if (!request.getPrice().equals(assistance.getPrice())) {
      assistance.setPrice(request.getPrice());
    }
    return assistanceMapper.entityToResponse(assistance);
  }

  @Override
  public List<AssistanceResponse> getAll() {
    List<Assistance> assistances = (List<Assistance>) assistanceRepository.findAll();
    return assistanceMapper.listOfEntitiesToListOfResponses(assistances);
  }
}
