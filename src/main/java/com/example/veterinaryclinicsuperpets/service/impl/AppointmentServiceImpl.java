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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
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
    Long appointmentId = appointmentRepository.save(appointment).getId();
    LocalTime startTime = LocalTime.parse(request.getStartTime());
    List<LocalTime>localTimeList = new ArrayList<>();
    if (request.getDuration()==60){
    localTimeList.add(startTime);
    localTimeList.add(startTime.plus(30, ChronoUnit.MINUTES));
    }else if(request.getDuration()==120){
      localTimeList.add(startTime);
      localTimeList.add(startTime.plus(30, ChronoUnit.MINUTES));
      localTimeList.add(startTime.plus(60, ChronoUnit.MINUTES));
      localTimeList.add(startTime.plus(90, ChronoUnit.MINUTES));
    }else{
      localTimeList.add(startTime);
    }
    for (LocalTime parsedTime : localTimeList) {
      TimeSlot timeSlot = new TimeSlot();
      timeSlot.setAppointmentId(appointmentId);
      timeSlot.setTime(parsedTime);
      timeRepository.save(timeSlot);
    }
    return appointmentId;
  }

  @Override
  public AppointmentResponse delete(Long id) {
    Appointment appointment =
        appointmentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    appointmentRepository.delete(appointment);
    List<TimeSlot> timeSlotList = timeRepository.findAllByAppointmentId(id);
    for (TimeSlot timeSlot : timeSlotList) {
      TimeSlot current = timeRepository.findById(timeSlot.getId()).orElseThrow(IllegalArgumentException::new);
      timeRepository.delete(current);
    }
    return appointmentMapper.entityToResponse(appointment);
  }

  @Override
  public void deleteAll(List<AppointmentResponse> appointmentList) {
    for (AppointmentResponse appointmentResponse : appointmentList) {
      Appointment appointment = appointmentRepository.findById(appointmentResponse.getId()).orElseThrow(IllegalArgumentException::new);
      delete(appointment.getId());
    }
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
    appointmentRepository.save(appointment);
    return appointmentMapper.entityToResponse(appointment);
  }

  @Override
  public AppointmentResponse addDescription(String description, Long id) {
    Appointment appointment =
        appointmentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    appointment.setDescription(description);
    appointment.setStatus(AppointmentStatus.PASSED);
    appointmentRepository.save(appointment);
    return appointmentMapper.entityToResponse(appointment);
  }

  @Override
  public List<AppointmentResponse> getAll() {
    List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
  }
  @Override
  public List<AppointmentResponse> getAllByPet(Long petId) {
    List<Appointment> appointments =
            appointmentRepository.findAllByPetId(petId);
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
  }
  @Override
  public List<AppointmentResponse> getAllByOwner(Long ownerId, String status) {
    List<Appointment> appointments =
        appointmentRepository.findAllByOwnerIdAndStatus(ownerId, AppointmentStatus.valueOf(status));
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
  }

  @Override
  public List<AppointmentResponse> getAllByVet(Long vetId, String status) {
    LocalDate today = LocalDate.now();
    List<Appointment> appointments;
    if (status.equals("UPCOMING")) {
      appointments =
          appointmentRepository
              .findAllByVetIdAndStatus(vetId, AppointmentStatus.valueOf(status))
              .stream()
              .filter(
                  appointment ->
                      (appointment.getDate().isAfter(today) || appointment.getDate().equals(today))
                          && appointment.getDescription() == null)
              .collect(Collectors.toList());
    } else {
      appointments =
          appointmentRepository.findAllByVetIdAndStatus(vetId, AppointmentStatus.valueOf(status));
    }
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
  }

  @Override
  public List<AppointmentResponse> getAllByWaitingForDescription(Long vetId, String status) {
    LocalDate today = LocalDate.now();
    List<Appointment> appointments =
        appointmentRepository
            .findAllByVetIdAndStatus(vetId, AppointmentStatus.valueOf(status))
            .stream()
            .filter(
                appointment ->
                    appointment.getDate().isBefore(today) && appointment.getDescription() == null)
            .collect(Collectors.toList());
    return appointmentMapper.listOfEntitiesToListOfResponses(appointments);
  }

  @Override
  public List<LocalTime> getAllFreeTimeSlotsForDateAndVet(Long id, String date, int duration) {
    LocalDate localDate = LocalDate.parse(date);
    List<LocalTime> allTimeSlots = getAllTimeSlots();
    List<AppointmentResponse> allAppointmentsByDateAndVetId =
        getAllAppointmentsByVetIdAndDate(id, localDate);
    List<TimeSlot> reservedTimeSlotsObjList = new ArrayList<>();

    for (AppointmentResponse appointment : allAppointmentsByDateAndVetId) {
      Long currentId = appointment.getId();
      reservedTimeSlotsObjList.addAll(timeRepository.findAllByAppointmentId(currentId));
    }

    List<LocalTime> reservedTimes = new ArrayList<>();
    reservedTimeSlotsObjList.forEach(element -> reservedTimes.add(element.getTime()));

    List<LocalTime> freeTimeSlots = new ArrayList<>();
    for (LocalTime time : allTimeSlots) {
      if (!reservedTimes.contains(time)) {
        freeTimeSlots.add(time);
      }
    }
    if (duration == 60) {
      List<LocalTime> freeTimeSlotsForLongAppointment = new ArrayList<>();
      List<List<LocalTime>> consecutiveSeries = findConsecutiveTimeSeries(freeTimeSlots, 2);
      for (List<LocalTime> consecutiveTimeSery : consecutiveSeries) {
        freeTimeSlotsForLongAppointment.add(consecutiveTimeSery.get(0));
      }
      return freeTimeSlotsForLongAppointment;
    } else if (duration == 120) {
      List<LocalTime> freeTimeSlotsForLongAppointment = new ArrayList<>();
      List<List<LocalTime>> consecutiveSeries = findConsecutiveTimeSeries(freeTimeSlots, 4);
      for (List<LocalTime> consecutiveTimeSery : consecutiveSeries) {
        freeTimeSlotsForLongAppointment.add(consecutiveTimeSery.get(0));
      }
      return freeTimeSlotsForLongAppointment;
    }
    return freeTimeSlots;
  }

  private List<List<LocalTime>> findConsecutiveTimeSeries(List<LocalTime> times, int seriesLength) {
    List<List<LocalTime>> consecutiveSeries = new ArrayList<>();
    List<LocalTime> currentSeries = new ArrayList<>();

    for (int i = 1; i < times.size(); i++) {
      LocalTime current = times.get(i);
      LocalTime previous = times.get(i - 1);
      if (current.minusMinutes(30).equals(previous)) {
        if (currentSeries.isEmpty()) {
          currentSeries.add(previous);
        }
        currentSeries.add(current);

        if (currentSeries.size() == seriesLength) {
          consecutiveSeries.add(new ArrayList<>(currentSeries));
          currentSeries.clear();
        }
      } else {
        currentSeries.clear();
      }
    }

    return consecutiveSeries;
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
