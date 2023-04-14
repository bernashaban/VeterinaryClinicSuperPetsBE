package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.mapper.AppointmentMapper;
import com.example.veterinaryclinicsuperpets.repository.AppointmentRepository;
import com.example.veterinaryclinicsuperpets.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
  private final AppointmentRepository appointmentRepository;
  private final AppointmentMapper appointmentMapper;

  @Override
  public AppointmentResponse getById(Long id) {
    Appointment appointment =
        appointmentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    return appointmentMapper.entityToResponse(appointment);
  }

  @Override
  public Long create(AppointmentRequest request) {
    Appointment appointment = appointmentMapper.requestToEntity(request);
    return appointmentRepository.save(appointment).getId();
  }

  @Override
  public AppointmentResponse delete(Long id) {
    Appointment appointment =
        appointmentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    appointmentRepository.delete(appointment);
    return appointmentMapper.entityToResponse(appointment);
  }

  @Override
  public AppointmentResponse update(AppointmentRequest request, Long id) {
    Appointment appointment =
        appointmentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    if (!request.getPet().equals(appointment.getPet())) {
      appointment.setPet(request.getPet());
    }
    if (request.getOwner() != appointment.getOwner()) {
      appointment.setOwner(request.getOwner());
    }
    if (!request.getDescription().equals(appointment.getDescription())) {
      appointment.setDescription(request.getDescription());
    }
    if (!request.getVeterinarian().equals(appointment.getVeterinarian())) {
      appointment.setVeterinarian(request.getVeterinarian());
    }
    if (!request.getDateTime().equals(appointment.getDateTime())) {
      appointment.setDateTime(request.getDateTime());
    }
    return appointmentMapper.entityToResponse(appointment);
  }

  @Override
  public List<AppointmentResponse> getAll() {
    List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
  }
}
