package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;

import java.util.List;

public interface AppointmentService {
  AppointmentResponse getById(Long id);

  Long create(AppointmentRequest request);

  AppointmentResponse delete(Long id);

  AppointmentResponse update(AppointmentRequest request, Long id);

  List<AppointmentResponse> getAll();
}
