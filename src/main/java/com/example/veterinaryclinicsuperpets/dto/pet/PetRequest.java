package com.example.veterinaryclinicsuperpets.dto.pet;

import com.example.veterinaryclinicsuperpets.entity.Owner;
import com.example.veterinaryclinicsuperpets.entity.enums.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetRequest {
  private String name;
  private int age;
  private PetType type;
  private Owner owner;
}
