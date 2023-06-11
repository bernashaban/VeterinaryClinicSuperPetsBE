package com.example.veterinaryclinicsuperpets.dto.appointment;

import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
    private Long id;
    private User owner;
    private Pet pet;
    private User veterinarian;
    private LocalDateTime dateTime;
    private String description;
    private AppointmentStatus status;
}
