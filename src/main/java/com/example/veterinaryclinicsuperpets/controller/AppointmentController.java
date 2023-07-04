package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.repository.TimeSlotRepository;
import com.example.veterinaryclinicsuperpets.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
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

  @PutMapping(value = "add-description/{id}")
  @PreAuthorize("hasAuthority('ROLE_VET')")
  public AppointmentResponse addDescription(
      @RequestBody String description, @PathVariable Long id) {
    return appointmentService.addDescription(description, id);
  }

  @GetMapping("/{vetId}/{date}/{duration}")
  public List<LocalTime> getAllFreeTimes(
      @PathVariable Long vetId,
      @PathVariable int duration,
      @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") String date) {
    return appointmentService.getAllFreeTimeSlotsForDateAndVet(vetId, date, duration);
  }

  @GetMapping("owner/{id}/{status}")
  public List<AppointmentResponse> getAllAppointmentForOwner(
      @PathVariable Long id, @PathVariable String status) {
    return appointmentService.getAllByOwner(id, status);
  }

  @GetMapping("/vet/{id}/{status}")
  public List<AppointmentResponse> getAllAppointmentForVet(
      @PathVariable Long id, @PathVariable String status) {
    return appointmentService.getAllByVet(id, status);
  }

  @GetMapping("/vet/waiting/{id}/{status}")
  public List<AppointmentResponse> getAllAppointmentForVetCondition(
      @PathVariable Long id, @PathVariable String status) {
    return appointmentService.getAllByWaitingForDescription(id, status);
  }
}
