package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
  private final AppointmentService appointmentService;

  @GetMapping("/{id}")
  public AppointmentResponse getAppointment(@PathVariable Long id) {
    return appointmentService.getById(id);
  }

  @GetMapping()
  public List<AppointmentResponse> getAllAppointments() {
    return appointmentService.getAll();
  }

  @DeleteMapping("/{id}")
  public AppointmentResponse deleteAppointment(@PathVariable Long id) {
    return appointmentService.delete(id);
  }

  @PostMapping()
  public Long postAppointment(@RequestBody AppointmentRequest request) {
    return appointmentService.create(request);
  }

  @PutMapping(value = "/{id}")
  public AppointmentResponse updateAppointment(
      @RequestBody AppointmentRequest request, @PathVariable Long id) {
    return appointmentService.update(request, id);
  }
}
