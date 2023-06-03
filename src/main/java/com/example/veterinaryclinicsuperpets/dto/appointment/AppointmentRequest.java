package com.example.veterinaryclinicsuperpets.dto.appointment;

import com.example.veterinaryclinicsuperpets.entity.Owner;
import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.Veterinarian;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {
  private Owner owner;
  private Pet pet;
  private Veterinarian veterinarian;
  private LocalDateTime dateTime;
  private String description;

}
