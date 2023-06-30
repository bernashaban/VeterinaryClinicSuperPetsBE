package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.entity.TimeSlot;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import com.example.veterinaryclinicsuperpets.mapper.AppointmentMapper;
import com.example.veterinaryclinicsuperpets.repository.AppointmentRepository;
import com.example.veterinaryclinicsuperpets.repository.TimeSlotRepository;
import com.example.veterinaryclinicsuperpets.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
  // todo make a method or cron job that changes
  // the status of every appointment that is passed
  private final AppointmentRepository appointmentRepository;
  private final AppointmentMapper appointmentMapper;
  private final TimeSlotRepository timeRepository;

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
    if (!request.getVet().equals(appointment.getVet())) {
      appointment.setVet(request.getVet());
    }
    if (!request.getDate().equals(appointment.getDate())) {
      appointment.setDate(request.getDate());
    }
    if (!request.getType().equals(appointment.getType())) {
      appointment.setType(request.getType());
    }
    if (!request.getStatus().equals(appointment.getStatus())) {
      appointment.setStatus(request.getStatus());
    }
    if (!request.getDescription().equals(appointment.getDescription())) {
      appointment.setDescription(request.getDescription());
    }
    return appointmentMapper.entityToResponse(appointment);
  }

  @Override
  public List<AppointmentResponse> getAll() {
    List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
  }

  @Override
  public List<AppointmentResponse> getAllByOwner(Long ownerId, String status) {
    List<Appointment> appointments = appointmentRepository.findAllByOwnerIdAndStatus(ownerId, AppointmentStatus.valueOf(status));
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
//    return appointmentMapper.listOfEntitiesToListOfResponses(appointments).stream()
//        .filter(
//            appointmentResponse -> Objects.equals(appointmentResponse.getOwner().getId(), ownerId))
//        .collect(Collectors.toList());
  }

  @Override
  public List<AppointmentResponse> getAllByVet(Long vetId, String status) {
    LocalDate today = LocalDate.now();
    List<Appointment> appointments;
    if(status.equals("UPCOMING")){
     appointments = appointmentRepository.findAllByVetIdAndStatus(vetId, AppointmentStatus.valueOf(status))
              .stream().filter(appointment -> (appointment.getDate().isAfter(today) || appointment.getDate().equals(today))
              && appointment.getDescription()==null).collect(Collectors.toList());
    }else{
      appointments = appointmentRepository.findAllByVetIdAndStatus(vetId, AppointmentStatus.valueOf(status));
    }

    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);

//    List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
//    return appointmentMapper.listOfEntitiesToListOfResponses(appointments).stream()
//        .filter(appointmentResponse -> Objects.equals(appointmentResponse.getVet().getId(), vetId))
//        .collect(Collectors.toList());
  }
  @Override
  public List<AppointmentResponse> getAllByWaitingForDescription(Long vetId, String status) {
    LocalDate today = LocalDate.now();
    List<Appointment> appointments = appointmentRepository.findAllByVetIdAndStatus(vetId, AppointmentStatus.valueOf(status))
            .stream().filter(appointment -> appointment.getDate().isBefore(today)
                    && appointment.getDescription()==null).collect(Collectors.toList());
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
//    List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
//    return appointmentMapper.listOfEntitiesToListOfResponses(appointments).stream()
//        .filter(appointmentResponse -> Objects.equals(appointmentResponse.getVet().getId(), vetId))
//        .collect(Collectors.toList());
  }

  @Override
  public List<LocalTime> getAllFreeTimeSlotsForDateAndVet(Long id, LocalDate date) {
    List<LocalTime> allTimeSlots = getAllTimeSlots();
    List<AppointmentResponse> allAppointmentsByDateAndVetId = getAllAppointmentsByVetIdAndDate(id, date);
    List<TimeSlot> reservedTimeSlotsObjList = new ArrayList<>();

    for (AppointmentResponse appointment : allAppointmentsByDateAndVetId) {
      Long currentId = appointment.getId();
      reservedTimeSlotsObjList.addAll(timeRepository.findAllByAppointmentId(currentId));
    }

    List<LocalTime> reservedTimes = new ArrayList<>();
    reservedTimeSlotsObjList.forEach(element->reservedTimes.add(element.getTime()));

    List<LocalTime> freeTimeSlots = new ArrayList<>();
    for (LocalTime time : allTimeSlots) {
      if (!reservedTimes.contains(time)) {
        freeTimeSlots.add(time);
      }
    }
//    int duration = 0;
//
//    if ("REVIEWS".equals(type) || "PREVENTIVE".equals(type)) {
//      duration = 30;
//    } else if ("RESEARCH".equals(type) || "DENTISTRY".equals(type)) {
//      duration = 60;
//    } else if ("CASTRATIONS".equals(type) || "SURGERY".equals(type)) {
//      duration = 120;
//    }
   // при 30 мин се показват всички часове
//    if(duration==60){
      //да не запозва от 11:30 или от 17:30 - най късно 11 или 17
//      freeTimeSlots.remove(LocalTime.parse("11:30"));
//      freeTimeSlots.remove(LocalTime.parse("17:30"));
      //трябва да има 2 последователни свободни

//      for (LocalTime time : freeTimeSlots) {
//        if(freeTimeSlots.contains(time.plus(30, ChronoUnit.MINUTES)) && freeTimeSlots.contains(time.plus(60, ChronoUnit.MINUTES))){
          //ако съдържа часа+2 последователни, може да се запази
//        }else{
//          freeTimeSlots.remove(time);
//        }
//      }

//    }else if(duration == 120){
      //да не започва от 10:30 или от 16:30 - най късно 10 или 16
//      freeTimeSlots.remove(LocalTime.parse("10:30"));
//      freeTimeSlots.remove(LocalTime.parse("11:00"));
//      freeTimeSlots.remove(LocalTime.parse("11:30"));
//      freeTimeSlots.remove(LocalTime.parse("16:30"));
//      freeTimeSlots.remove(LocalTime.parse("17:00"));
//      freeTimeSlots.remove(LocalTime.parse("17:30"));
      //трябва да има 4 последователни свободни


//    }

    return freeTimeSlots;
  }

  private List<AppointmentResponse> getAllAppointmentsByVetIdAndDate(Long id, LocalDate date) {
    List<Appointment> appointments = appointmentRepository.findAllByVetIdAndDate(id, date);
    return appointmentMapper.listOfEntitiesToListOfResponses(new ArrayList<>(appointments));
  }

  private List<LocalTime> getAllTimeSlots() {
    return new ArrayList<>(
        Arrays.asList(
            LocalTime.parse("09:00:00"),
            LocalTime.parse("09:30:00"),
            LocalTime.parse("10:00:00"),
            LocalTime.parse("10:30:00"),
            LocalTime.parse("11:00:00"),
            LocalTime.parse("11:30:00"),
            LocalTime.parse("13:00:00"),
            LocalTime.parse("13:30:00"),
            LocalTime.parse("14:00:00"),
            LocalTime.parse("14:30:00"),
            LocalTime.parse("15:00:00"),
            LocalTime.parse("15:30:00"),
            LocalTime.parse("16:00:00"),
            LocalTime.parse("16:30:00"),
            LocalTime.parse("17:00:00"),
            LocalTime.parse("17:30:00")));
  }
}
