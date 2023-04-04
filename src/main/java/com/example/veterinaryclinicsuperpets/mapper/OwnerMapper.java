package com.example.veterinaryclinicsuperpets.mapper;

import com.example.veterinaryclinicsuperpets.dto.owner.OwnerRequest;
import com.example.veterinaryclinicsuperpets.dto.owner.OwnerResponse;
import com.example.veterinaryclinicsuperpets.entity.Owner;

import java.util.List;

public interface OwnerMapper {
  OwnerResponse entityToResponse(Owner entity);

  Owner requestToEntity(OwnerRequest entityRequest);

  List<OwnerResponse> listOfEntitiesToListOfResponses(List<Owner> entities);
}
