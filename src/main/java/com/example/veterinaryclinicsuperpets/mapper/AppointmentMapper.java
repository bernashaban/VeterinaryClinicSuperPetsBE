package com.example.veterinaryclinicsuperpets.mapper;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;

import java.util.List;

public interface AppointmentMapper {
  AppointmentResponse entityToResponse(Appointment entity);

  Appointment requestToEntity(AppointmentRequest entityRequest);

  List<AppointmentResponse> listOfEntitiesToListOfResponses(List<Appointment> entities);
}
