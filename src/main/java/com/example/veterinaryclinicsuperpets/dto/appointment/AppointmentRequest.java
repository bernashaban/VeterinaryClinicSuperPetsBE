package com.example.veterinaryclinicsuperpets.dto.appointment;


import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {
  private User owner;
  private Pet pet;
  private User veterinarian;
  private LocalDateTime dateTime;
  private String description;

}
