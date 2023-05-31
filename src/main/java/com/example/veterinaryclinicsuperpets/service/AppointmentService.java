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

  List<AppointmentResponse> getAll();

  Map<LocalDate, Set<LocalTime>> getAllAppointmentsForAWeekAhead(Long id, String appointmentStatus);
}
