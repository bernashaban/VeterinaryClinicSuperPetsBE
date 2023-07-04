package com.example.veterinaryclinicsuperpets.dto.appointment;


import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.User;


import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {
  private User owner;
  private Pet pet;
  private User vet;
  private LocalDate date;
  private String startTime;
  private int duration;
  private AppointmentStatus status;
  private AppointmentType type;
  private String description;

}
