package com.example.veterinaryclinicsuperpets.dto.appointment;

import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
    private Long id;
    private User owner;
    private Pet pet;
    private User vet;
    private LocalDate date;
    private int duration;
    private String description;
    private AppointmentStatus status;
    private AppointmentType type;
}
