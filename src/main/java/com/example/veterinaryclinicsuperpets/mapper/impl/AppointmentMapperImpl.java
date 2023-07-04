package com.example.veterinaryclinicsuperpets.mapper.impl;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.entity.TimeSlot;
import com.example.veterinaryclinicsuperpets.mapper.AppointmentMapper;
import com.example.veterinaryclinicsuperpets.repository.TimeSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentMapperImpl implements AppointmentMapper {
  private final TimeSlotRepository timeRepository;

  @Override
  public AppointmentResponse entityToResponse(Appointment entity) {
    AppointmentResponse appointmentResponse = new AppointmentResponse();
    List<TimeSlot> timeSlots = timeRepository.findAllByAppointmentId(entity.getId());
    List<String> times = new ArrayList<>();
    for (TimeSlot timeSlot : timeSlots) {
      times.add(timeSlot.getTime().toString());
    }
    appointmentResponse.setId(entity.getId());
    appointmentResponse.setOwner(entity.getOwner());
    appointmentResponse.setPet(entity.getPet());
    appointmentResponse.setVet(entity.getVet());
    appointmentResponse.setDescription(entity.getDescription());
    appointmentResponse.setDate(entity.getDate());
    appointmentResponse.setStatus(entity.getStatus());
    appointmentResponse.setType(entity.getType());
    appointmentResponse.setDuration(entity.getDuration());
    appointmentResponse.setTimes(times);
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
