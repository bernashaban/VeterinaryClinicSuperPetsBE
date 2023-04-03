package com.example.veterinaryclinicsuperpets.mapper;

import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceRequest;
import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceResponse;
import com.example.veterinaryclinicsuperpets.entity.Assistance;

import java.util.List;

public interface AssistanceMapper {
  AssistanceResponse entityToResponse(Assistance entity);

  Assistance requestToEntity(AssistanceRequest entityRequest);

  List<AssistanceResponse> listOfEntitiesToListOfResponses(List<Assistance> entities);
}
