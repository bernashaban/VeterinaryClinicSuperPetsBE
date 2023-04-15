package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceRequest;
import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceResponse;
import com.example.veterinaryclinicsuperpets.entity.Assistance;
import com.example.veterinaryclinicsuperpets.mapper.AssistanceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AssistanceMapperImpl implements AssistanceMapper {
  @Override
  public AssistanceResponse entityToResponse(Assistance entity) {
    AssistanceResponse assistanceResponse = new AssistanceResponse();
    assistanceResponse.setId(entity.getId());
    assistanceResponse.setName(entity.getName());
    assistanceResponse.setPrice(entity.getPrice());
    assistanceResponse.setServiceType(entity.getServiceType());
    return assistanceResponse;
  }

  @Override
  public Assistance requestToEntity(AssistanceRequest entityRequest) {
    Assistance assistance = new Assistance();
    assistance.setName(entityRequest.getName());
    assistance.setPrice(entityRequest.getPrice());
    assistance.setServiceType(entityRequest.getServiceType());
    return assistance;
  }

  @Override
  public List<AssistanceResponse> listOfEntitiesToListOfResponses(List<Assistance> entities) {
    return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
  }
}
