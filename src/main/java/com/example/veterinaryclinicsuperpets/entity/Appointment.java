package com.example.veterinaryclinicsuperpets.entity;

import java.time.LocalDateTime;

public class Appointment {
    private Owner owner;
    private Pet pet;
    private Veterinarian veterinarian;
    private LocalDateTime dateTime;
    private String description;
}
