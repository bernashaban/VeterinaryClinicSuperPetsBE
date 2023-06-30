package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.mapper.AppointmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentMapperImpl implements AppointmentMapper {
  @Override
  public AppointmentResponse entityToResponse(Appointment entity) {

    //
    //    private int duration;
    //    private String description;
    //    private AppointmentStatus status;
    //    private AppointmentType type;
    AppointmentResponse appointmentResponse = new AppointmentResponse();
    appointmentResponse.setId(entity.getId());
    appointmentResponse.setOwner(entity.getOwner());
    appointmentResponse.setPet(entity.getPet());
    appointmentResponse.setVet(entity.getVet());
    appointmentResponse.setDescription(entity.getDescription());
    appointmentResponse.setDate(entity.getDate());
    appointmentResponse.setStatus(entity.getStatus());
    appointmentResponse.setType(entity.getType());
    appointmentResponse.setDuration(entity.getDuration());
    return appointmentResponse;
  }

  @Override
  public Appointment requestToEntity(AppointmentRequest entityRequest) {
    Appointment appointment = new Appointment();
    appointment.setOwner(entityRequest.getOwner());
    appointment.setPet(entityRequest.getPet());
    appointment.setVet(entityRequest.getVet());
    appointment.setDate(entityRequest.getDate());
    appointment.setStatus(entityRequest.getStatus());
    appointment.setType(entityRequest.getType());
    appointment.setDuration(entityRequest.getDuration());
    return appointment;
  }

  @Override
  public List<AppointmentResponse> listOfEntitiesToListOfResponses(List<Appointment> entities) {
    return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
  }
}
