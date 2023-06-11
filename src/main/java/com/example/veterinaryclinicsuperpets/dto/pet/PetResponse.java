package com.example.veterinaryclinicsuperpets.dto.pet;


import com.example.veterinaryclinicsuperpets.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetResponse {
  private Long id;
  private String name;
  private int age;
  private int type;
  private int gender;
  private User owner;
}
