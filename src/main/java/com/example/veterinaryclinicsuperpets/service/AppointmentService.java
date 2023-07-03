package com.example.veterinaryclinicsuperpets.service;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AppointmentService {
  AppointmentResponse getById(Long id);

  Long create(AppointmentRequest request);

  AppointmentResponse delete(Long id);

  AppointmentResponse update(AppointmentRequest request, Long id);
  AppointmentResponse addDescription(String description, Long id);

  List<AppointmentResponse> getAll();
  List<AppointmentResponse> getAllByOwner(Long ownerId, String status);
  List<AppointmentResponse> getAllByVet(Long vetId, String status);
  List<AppointmentResponse> getAllByWaitingForDescription(Long vetId, String status);

  List<LocalTime> getAllFreeTimeSlotsForDateAndVet(Long vetId, LocalDate date);
}
