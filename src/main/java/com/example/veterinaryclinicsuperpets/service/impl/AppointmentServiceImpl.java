package com.example.veterinaryclinicsuperpets.service.impl;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import com.example.veterinaryclinicsuperpets.mapper.AppointmentMapper;
import com.example.veterinaryclinicsuperpets.repository.AppointmentRepository;
import com.example.veterinaryclinicsuperpets.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
  //todo make a method or cron job that changes
  // the status of every appointment that is passed
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

  @Override
  public Map<LocalDate, Set<LocalTime>> getAllAppointmentsForAWeekAhead(
      Long id, String appointmentStatus) {
    // взимаме всички обекти - запазени часове
    List<AppointmentResponse> reservedAppointments =
        getAllAppointmentsByVetIdAndStatus(id, AppointmentStatus.valueOf(appointmentStatus));
    // мап, в който ще парснем инфото от обектите
    // датата е уникален елемент в мапа - ключ, от него може да има само един с тази стойност
    // всяка дата пази лист с часове, които вече някой потребител е запазил
    Map<LocalDate, Set<LocalTime>> reservedMap = new HashMap<>();
    // взимаме един по един датата и часа за всеки обект
    // проверяваме дали текущата дата вече не е запазена в мапа
    // ако я има вече запазена, вземаме сета и, и запазваме часа
    // не проверяваме дани вече има такъв час в сета,
    // понеже и при него запазваните стойности са уникални
    // ако текущата дата не съществува в мапа, се добавя
    // заедно с нов хашсет
    for (AppointmentResponse reservedAppointment : reservedAppointments) {
      LocalDate currentDate = reservedAppointment.getDateTime().toLocalDate();
      LocalTime currentTime = reservedAppointment.getDateTime().toLocalTime();
      if (reservedMap.containsKey(currentDate)) {
        reservedMap.get(currentDate).add(currentTime);
      } else {
        reservedMap.put(currentDate, new HashSet<>());
        reservedMap.get(currentDate).add(currentTime);
      }
    }

    // правим по същия начин мап с ключ дати и сет с часове
    // за всички възможни свободни часове за 1 седмица напред
    Map<LocalDate, Set<LocalTime>> allPossibleAppointmentsMap = new LinkedHashMap<>();
    // вземаме датите
    List<LocalDate> listOfAllDates = getWeekOfDaysFromToday();
    // вземаме часовете
    Set<LocalTime> listOfAllTimes = getAllHoursForAppointments();
    // добавяме сета с часове като стойност(value) за всяка дата
    for (LocalDate localDate : listOfAllDates) {
      allPossibleAppointmentsMap.put(localDate, listOfAllTimes);
    }
    // за всяка дата взимаме листа със свободни часове
    // обхождаме всеки лист и ако същия час го има
    // в списъка с запазените часове, го изтриваме от
    // списъка със свободните

    // всяко ентри си има дата - ключ и валуе - лист от часове
    // allPossibleAppointmentsMap - съдържа всички възможни часове за всяка от датите
    allPossibleAppointmentsMap.forEach(
        (date, value) -> {
          if (reservedMap.containsKey(date)) {
            Set<LocalTime> reservedValues = new TreeSet<>(reservedMap.get(date));
            Set<LocalTime> updatedValue = createNewSetWithReservedValues(value, reservedValues);
            allPossibleAppointmentsMap.put(date, updatedValue);
          }
        });

    return allPossibleAppointmentsMap;
    //return new HashMap<>();
  }

  private List<AppointmentResponse> getAllAppointmentsByVetIdAndStatus(
          Long id, AppointmentStatus appointmentStatus) {
    List<Appointment> appointments =
            appointmentRepository.findAllByVeterinarianIdAndStatus(id, appointmentStatus);
    return appointmentMapper.listOfEntitiesToListOfResponses(new ArrayList<>(appointments));
  }

  private Set<LocalTime> createNewSetWithReservedValues(
      Set<LocalTime> originalSet, Set<LocalTime> reservedValues) {
    Set<LocalTime> updatedSet = new TreeSet<>(originalSet);
    updatedSet.removeAll(reservedValues);
    return updatedSet;
  }

  private List<LocalDate> getWeekOfDaysFromToday() {
    List<LocalDate> aWeekOfDaysFromToday = new ArrayList<>();
    LocalDate today = LocalDate.now();
    for (int i = 0; i < 7; i++) {
      if (i == 0) {
        aWeekOfDaysFromToday.add(today);
      } else {
        LocalDate nextDay = today.plus(i, ChronoUnit.DAYS);
        aWeekOfDaysFromToday.add(nextDay);
      }
    }
    return aWeekOfDaysFromToday;
  }

  private Set<LocalTime> getAllHoursForAppointments() {
    return new TreeSet<>(
        Arrays.asList(
            LocalTime.parse("09:00:00"),
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
