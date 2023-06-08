package com.example.veterinaryclinicsuperpets.dto.pet;

import com.example.veterinaryclinicsuperpets.entity.Owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetRequest {
  private String name;
  private int age;
  private int type;
  private int gender;
  private Owner owner;
}
