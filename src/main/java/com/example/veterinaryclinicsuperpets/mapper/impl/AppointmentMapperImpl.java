package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.mapper.AppointmentMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentMapperImpl implements AppointmentMapper {
  @Override
  public AppointmentResponse entityToResponse(Appointment entity) {
    AppointmentResponse appointmentResponse = new AppointmentResponse();
    appointmentResponse.setId(entity.getId());
    appointmentResponse.setOwner(entity.getOwner());
    appointmentResponse.setPet(entity.getPet());
    appointmentResponse.setVeterinarian(entity.getVeterinarian());
    appointmentResponse.setDescription(entity.getDescription());
    appointmentResponse.setDateTime(entity.getDateTime());
    return appointmentResponse;
  }

  @Override
  public Appointment requestToEntity(AppointmentRequest entityRequest) {
    Appointment appointment = new Appointment();
    appointment.setOwner(entityRequest.getOwner());
    appointment.setPet(entityRequest.getPet());
    appointment.setVeterinarian(entityRequest.getVeterinarian());
    appointment.setDescription(entityRequest.getDescription());
    appointment.setDateTime(entityRequest.getDateTime());
    return appointment;
  }

  @Override
  public List<AppointmentResponse> listOfEntitiesToListOfResponses(List<Appointment> entities) {
    return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
  }
}
