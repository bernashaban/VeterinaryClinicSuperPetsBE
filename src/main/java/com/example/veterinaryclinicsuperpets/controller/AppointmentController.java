package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.entity.TimeSlot;
import com.example.veterinaryclinicsuperpets.repository.TimeSlotRepository;
import com.example.veterinaryclinicsuperpets.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AppointmentController {
  private final AppointmentService appointmentService;
  private final TimeSlotRepository timeSlotRepository;

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

  @PostMapping("/{times}")
  public Long postAppointment(@RequestBody AppointmentRequest request, @PathVariable String times) {
    Long appointmentId = appointmentService.create(request);
    addTimes(times, appointmentId);
    return appointmentId;
  }

  private void addTimes(String times, Long id){
    List<LocalTime> parsedTimes = Arrays.stream(times.split("-"))
            .map(LocalTime::parse).collect(Collectors.toList());
    for (LocalTime parsedTime : parsedTimes) {
      TimeSlot timeSlot = new TimeSlot();
      timeSlot.setTime(parsedTime);
      timeSlot.setAppointmentId(id);
      timeSlotRepository.save(timeSlot);
    }
  }

  @PutMapping(value = "/{id}")
  public AppointmentResponse updateAppointment(
      @RequestBody AppointmentRequest request, @PathVariable Long id) {
    return appointmentService.update(request, id);
  }
  @PutMapping(value = "add-description/{id}")
  public AppointmentResponse addDescription(
          @RequestBody String description, @PathVariable Long id) {
    return appointmentService.addDescription(description, id);
  }

  @GetMapping("/{vetId}/{date}")
  public List<LocalTime> getAllFreeTimes(@PathVariable Long vetId,
                                         @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
    return appointmentService.getAllFreeTimeSlotsForDateAndVet(vetId, date);
  }

  @GetMapping("owner/{id}/{status}")
  public List<AppointmentResponse> getAllAppointmentForOwner(@PathVariable Long id,@PathVariable String status) {
    return appointmentService.getAllByOwner(id, status);
  }

  @GetMapping("/vet/{id}/{status}")
  public List<AppointmentResponse> getAllAppointmentForVet(@PathVariable Long id,@PathVariable String status) {
    return appointmentService.getAllByVet(id,status);
  }

  @GetMapping("/vet/waiting/{id}/{status}")
  public List<AppointmentResponse> getAllAppointmentForVetCondition(@PathVariable Long id,@PathVariable String status) {
    return appointmentService.getAllByWaitingForDescription(id,status);
  }
}
