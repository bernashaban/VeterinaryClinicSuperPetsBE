package com.example.veterinaryclinicsuperpets.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest;
import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.TimeSlot;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentType;
import com.example.veterinaryclinicsuperpets.mapper.AppointmentMapper;
import com.example.veterinaryclinicsuperpets.repository.AppointmentRepository;
import com.example.veterinaryclinicsuperpets.repository.TimeSlotRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AppointmentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AppointmentServiceImplTest {
    @MockBean
    private AppointmentMapper appointmentMapper;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentServiceImpl appointmentServiceImpl;

    @MockBean
    private TimeSlotRepository timeSlotRepository;

    /**
     * Method under test: {@link AppointmentServiceImpl#getById(Long)}
     */
    @Test
    void testGetById() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        when(appointmentMapper.entityToResponse((Appointment) any())).thenReturn(appointmentResponse);
        assertSame(appointmentResponse, appointmentServiceImpl.getById(123L));
        verify(appointmentRepository).findById((Long) any());
        verify(appointmentMapper).entityToResponse((Appointment) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getById(Long)}
     */
    @Test
    void testGetById2() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        when(appointmentMapper.entityToResponse((Appointment) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> appointmentServiceImpl.getById(123L));
        verify(appointmentRepository).findById((Long) any());
        verify(appointmentMapper).entityToResponse((Appointment) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#create(AppointmentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreate() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read the array length because "<local7>" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.create(AppointmentServiceImpl.java:51)
        //   In order to prevent create(AppointmentRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   create(AppointmentRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        when(appointmentRepository.save((Appointment) any())).thenReturn(appointment);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("Roles");
        user4.setSpeciality("Speciality");
        user4.setUniversityInfo("University Info");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("Roles");
        user5.setSpeciality("Speciality");
        user5.setUniversityInfo("University Info");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);
        when(appointmentMapper.requestToEntity((AppointmentRequest) any())).thenReturn(appointment1);
        appointmentServiceImpl.create(new AppointmentRequest());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#create(AppointmentRequest)}
     */
    @Test
    void testCreate2() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        when(appointmentRepository.save((Appointment) any())).thenReturn(appointment);
        when(appointmentMapper.requestToEntity((AppointmentRequest) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> appointmentServiceImpl.create(new AppointmentRequest()));
        verify(appointmentMapper).requestToEntity((AppointmentRequest) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#create(AppointmentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreate3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.time.format.DateTimeParseException: Text 'Times' could not be parsed at index 0
        //       at java.time.format.DateTimeFormatter.parseResolved0(DateTimeFormatter.java:2052)
        //       at java.time.format.DateTimeFormatter.parse(DateTimeFormatter.java:1954)
        //       at java.time.LocalTime.parse(LocalTime.java:465)
        //       at java.time.LocalTime.parse(LocalTime.java:450)
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.create(AppointmentServiceImpl.java:52)
        //   In order to prevent create(AppointmentRequest)
        //   from throwing DateTimeParseException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   create(AppointmentRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        when(appointmentRepository.save((Appointment) any())).thenReturn(appointment);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("Roles");
        user4.setSpeciality("Speciality");
        user4.setUniversityInfo("University Info");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("Roles");
        user5.setSpeciality("Speciality");
        user5.setUniversityInfo("University Info");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);
        when(appointmentMapper.requestToEntity((AppointmentRequest) any())).thenReturn(appointment1);
        User owner = new User();
        Pet pet2 = new Pet();
        appointmentServiceImpl
                .create(new AppointmentRequest(owner, pet2, new User(), LocalDate.ofEpochDay(1L), new String[]{"Times"}, 1,
                        AppointmentStatus.UPCOMING, AppointmentType.REVIEWS, "The characteristics of someone or something"));
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#create(AppointmentRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreate4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest.getTimes()" because "request" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.create(AppointmentServiceImpl.java:49)
        //   In order to prevent create(AppointmentRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   create(AppointmentRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        when(appointmentRepository.save((Appointment) any())).thenReturn(appointment);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("Roles");
        user4.setSpeciality("Speciality");
        user4.setUniversityInfo("University Info");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("Roles");
        user5.setSpeciality("Speciality");
        user5.setUniversityInfo("University Info");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);
        when(appointmentMapper.requestToEntity((AppointmentRequest) any())).thenReturn(appointment1);
        appointmentServiceImpl.create(null);
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#delete(Long)}
     */
    @Test
    void testDelete() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);
        doNothing().when(appointmentRepository).delete((Appointment) any());
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        when(appointmentMapper.entityToResponse((Appointment) any())).thenReturn(appointmentResponse);
        assertSame(appointmentResponse, appointmentServiceImpl.delete(123L));
        verify(appointmentRepository).findById((Long) any());
        verify(appointmentRepository).delete((Appointment) any());
        verify(appointmentMapper).entityToResponse((Appointment) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#delete(Long)}
     */
    @Test
    void testDelete2() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);
        doNothing().when(appointmentRepository).delete((Appointment) any());
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        when(appointmentMapper.entityToResponse((Appointment) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> appointmentServiceImpl.delete(123L));
        verify(appointmentRepository).findById((Long) any());
        verify(appointmentRepository).delete((Appointment) any());
        verify(appointmentMapper).entityToResponse((Appointment) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#update(AppointmentRequest, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.veterinaryclinicsuperpets.entity.User.equals(Object)" because the return value of "com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentRequest.getVet()" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.update(AppointmentServiceImpl.java:75)
        //   In order to prevent update(AppointmentRequest, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(AppointmentRequest, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        appointmentServiceImpl.update(new AppointmentRequest(), 123L);
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#update(AppointmentRequest, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.update(AppointmentServiceImpl.java:74)
        //   In order to prevent update(AppointmentRequest, Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(AppointmentRequest, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(appointmentRepository.findById((Long) any())).thenReturn(Optional.empty());
        appointmentServiceImpl.update(new AppointmentRequest(), 123L);
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#update(AppointmentRequest, Long)}
     */
    @Test
    void testUpdate3() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("Roles");
        user4.setSpeciality("Speciality");
        user4.setUniversityInfo("University Info");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("Roles");
        user5.setSpeciality("Speciality");
        user5.setUniversityInfo("University Info");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);
        when(appointmentRepository.save((Appointment) any())).thenReturn(appointment1);
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        when(appointmentMapper.entityToResponse((Appointment) any())).thenReturn(appointmentResponse);
        User owner = new User();
        Pet pet2 = new Pet();
        assertSame(appointmentResponse,
                appointmentServiceImpl.update(
                        new AppointmentRequest(owner, pet2, new User(), LocalDate.ofEpochDay(1L), new String[]{"Times"}, 1,
                                AppointmentStatus.UPCOMING, AppointmentType.REVIEWS, "The characteristics of someone or something"),
                        123L));
        verify(appointmentRepository).save((Appointment) any());
        verify(appointmentRepository).findById((Long) any());
        verify(appointmentMapper).entityToResponse((Appointment) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#update(AppointmentRequest, Long)}
     */
    @Test
    void testUpdate4() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("Roles");
        user4.setSpeciality("Speciality");
        user4.setUniversityInfo("University Info");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("Roles");
        user5.setSpeciality("Speciality");
        user5.setUniversityInfo("University Info");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);
        when(appointmentRepository.save((Appointment) any())).thenReturn(appointment1);
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        when(appointmentMapper.entityToResponse((Appointment) any()))
                .thenThrow(new IllegalArgumentException("The characteristics of someone or something"));
        User owner = new User();
        Pet pet2 = new Pet();
        assertThrows(IllegalArgumentException.class,
                () -> appointmentServiceImpl.update(
                        new AppointmentRequest(owner, pet2, new User(), LocalDate.ofEpochDay(1L), new String[]{"Times"}, 1,
                                AppointmentStatus.UPCOMING, AppointmentType.REVIEWS, "The characteristics of someone or something"),
                        123L));
        verify(appointmentRepository).save((Appointment) any());
        verify(appointmentRepository).findById((Long) any());
        verify(appointmentMapper).entityToResponse((Appointment) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#addDescription(String, Long)}
     */
    @Test
    void testAddDescription() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("Roles");
        user4.setSpeciality("Speciality");
        user4.setUniversityInfo("University Info");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("Roles");
        user5.setSpeciality("Speciality");
        user5.setUniversityInfo("University Info");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);
        when(appointmentRepository.save((Appointment) any())).thenReturn(appointment1);
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        when(appointmentMapper.entityToResponse((Appointment) any())).thenReturn(appointmentResponse);
        assertSame(appointmentResponse,
                appointmentServiceImpl.addDescription("The characteristics of someone or something", 123L));
        verify(appointmentRepository).save((Appointment) any());
        verify(appointmentRepository).findById((Long) any());
        verify(appointmentMapper).entityToResponse((Appointment) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#addDescription(String, Long)}
     */
    @Test
    void testAddDescription2() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);
        Optional<Appointment> ofResult = Optional.of(appointment);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("Roles");
        user4.setSpeciality("Speciality");
        user4.setUniversityInfo("University Info");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("Roles");
        user5.setSpeciality("Speciality");
        user5.setUniversityInfo("University Info");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);
        when(appointmentRepository.save((Appointment) any())).thenReturn(appointment1);
        when(appointmentRepository.findById((Long) any())).thenReturn(ofResult);
        when(appointmentMapper.entityToResponse((Appointment) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class,
                () -> appointmentServiceImpl.addDescription("The characteristics of someone or something", 123L));
        verify(appointmentRepository).save((Appointment) any());
        verify(appointmentRepository).findById((Long) any());
        verify(appointmentMapper).entityToResponse((Appointment) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        when(appointmentRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> appointmentServiceImpl.getAll());
        verify(appointmentRepository).findAll();
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByOwner(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllByOwner() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus.Status
        //       at java.lang.Enum.valueOf(Enum.java:273)
        //       at com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus.valueOf(AppointmentStatus.java:3)
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.getAllByOwner(AppointmentServiceImpl.java:111)
        //   In order to prevent getAllByOwner(Long, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllByOwner(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        appointmentServiceImpl.getAllByOwner(123L, "Status");
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByOwner(Long, String)}
     */
    @Test
    void testGetAllByOwner2() {
        when(appointmentRepository.findAllByOwnerIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(new ArrayList<>());
        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        List<AppointmentResponse> actualAllByOwner = appointmentServiceImpl.getAllByOwner(123L, "UPCOMING");
        assertSame(appointmentResponseList, actualAllByOwner);
        assertTrue(actualAllByOwner.isEmpty());
        verify(appointmentRepository).findAllByOwnerIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByOwner(Long, String)}
     */
    @Test
    void testGetAllByOwner3() {
        when(appointmentRepository.findAllByOwnerIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(new ArrayList<>());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> appointmentServiceImpl.getAllByOwner(123L, "UPCOMING"));
        verify(appointmentRepository).findAllByOwnerIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByVet(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllByVet() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus.Status
        //       at java.lang.Enum.valueOf(Enum.java:273)
        //       at com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus.valueOf(AppointmentStatus.java:3)
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.getAllByVet(AppointmentServiceImpl.java:124)
        //   In order to prevent getAllByVet(Long, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllByVet(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        appointmentServiceImpl.getAllByVet(123L, "Status");
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByVet(Long, String)}
     */
    @Test
    void testGetAllByVet2() {
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(new ArrayList<>());
        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        List<AppointmentResponse> actualAllByVet = appointmentServiceImpl.getAllByVet(123L, "UPCOMING");
        assertSame(appointmentResponseList, actualAllByVet);
        assertTrue(actualAllByVet.isEmpty());
        verify(appointmentRepository).findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByVet(Long, String)}
     */
    @Test
    void testGetAllByVet3() {
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(new ArrayList<>());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenThrow(new IllegalArgumentException("UPCOMING"));
        assertThrows(IllegalArgumentException.class, () -> appointmentServiceImpl.getAllByVet(123L, "UPCOMING"));
        verify(appointmentRepository).findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByVet(Long, String)}
     */
    @Test
    void testGetAllByVet4() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("UPCOMING");
        user.setSpeciality("UPCOMING");
        user.setUniversityInfo("UPCOMING");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("UPCOMING");
        user1.setSpeciality("UPCOMING");
        user1.setUniversityInfo("UPCOMING");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("UPCOMING");
        user2.setSpeciality("UPCOMING");
        user2.setUniversityInfo("UPCOMING");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);

        ArrayList<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment);
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(appointmentList);
        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        List<AppointmentResponse> actualAllByVet = appointmentServiceImpl.getAllByVet(123L, "UPCOMING");
        assertSame(appointmentResponseList, actualAllByVet);
        assertTrue(actualAllByVet.isEmpty());
        verify(appointmentRepository).findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByVet(Long, String)}
     */
    @Test
    void testGetAllByVet5() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("UPCOMING");
        user.setSpeciality("UPCOMING");
        user.setUniversityInfo("UPCOMING");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("UPCOMING");
        user1.setSpeciality("UPCOMING");
        user1.setUniversityInfo("UPCOMING");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("UPCOMING");
        user2.setSpeciality("UPCOMING");
        user2.setUniversityInfo("UPCOMING");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("UPCOMING");
        user3.setSpeciality("UPCOMING");
        user3.setUniversityInfo("UPCOMING");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("UPCOMING");
        user4.setSpeciality("UPCOMING");
        user4.setUniversityInfo("UPCOMING");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("UPCOMING");
        user5.setSpeciality("UPCOMING");
        user5.setUniversityInfo("UPCOMING");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);

        ArrayList<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment1);
        appointmentList.add(appointment);
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(appointmentList);
        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        List<AppointmentResponse> actualAllByVet = appointmentServiceImpl.getAllByVet(123L, "UPCOMING");
        assertSame(appointmentResponseList, actualAllByVet);
        assertTrue(actualAllByVet.isEmpty());
        verify(appointmentRepository).findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByVet(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllByVet6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.time.LocalDate.isAfter(java.time.chrono.ChronoLocalDate)" because the return value of "com.example.veterinaryclinicsuperpets.entity.Appointment.getDate()" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.lambda$getAllByVet$0(AppointmentServiceImpl.java:121)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.getAllByVet(AppointmentServiceImpl.java:122)
        //   In order to prevent getAllByVet(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllByVet(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("UPCOMING");
        user.setSpeciality("UPCOMING");
        user.setUniversityInfo("UPCOMING");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("UPCOMING");
        user1.setSpeciality("UPCOMING");
        user1.setUniversityInfo("UPCOMING");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("UPCOMING");
        user2.setSpeciality("UPCOMING");
        user2.setUniversityInfo("UPCOMING");
        user2.setUsername("janedoe");
        Appointment appointment = mock(Appointment.class);
        when(appointment.getDate()).thenReturn(null);
        doNothing().when(appointment).setDate((LocalDate) any());
        doNothing().when(appointment).setDescription((String) any());
        doNothing().when(appointment).setDuration(anyInt());
        doNothing().when(appointment).setId((Long) any());
        doNothing().when(appointment).setOwner((User) any());
        doNothing().when(appointment).setPet((Pet) any());
        doNothing().when(appointment).setStatus((AppointmentStatus) any());
        doNothing().when(appointment).setType((AppointmentType) any());
        doNothing().when(appointment).setVet((User) any());
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);

        ArrayList<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment);
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(appointmentList);
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any())).thenReturn(new ArrayList<>());
        appointmentServiceImpl.getAllByVet(123L, "UPCOMING");
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByWaitingForDescription(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllByWaitingForDescription() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus.Status
        //       at java.lang.Enum.valueOf(Enum.java:273)
        //       at com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus.valueOf(AppointmentStatus.java:3)
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.getAllByWaitingForDescription(AppointmentServiceImpl.java:131)
        //   In order to prevent getAllByWaitingForDescription(Long, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllByWaitingForDescription(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        appointmentServiceImpl.getAllByWaitingForDescription(123L, "Status");
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByWaitingForDescription(Long, String)}
     */
    @Test
    void testGetAllByWaitingForDescription2() {
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(new ArrayList<>());
        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        List<AppointmentResponse> actualAllByWaitingForDescription = appointmentServiceImpl
                .getAllByWaitingForDescription(123L, "UPCOMING");
        assertSame(appointmentResponseList, actualAllByWaitingForDescription);
        assertTrue(actualAllByWaitingForDescription.isEmpty());
        verify(appointmentRepository).findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByWaitingForDescription(Long, String)}
     */
    @Test
    void testGetAllByWaitingForDescription3() {
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(new ArrayList<>());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class,
                () -> appointmentServiceImpl.getAllByWaitingForDescription(123L, "UPCOMING"));
        verify(appointmentRepository).findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByWaitingForDescription(Long, String)}
     */
    @Test
    void testGetAllByWaitingForDescription4() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);

        ArrayList<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment);
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(appointmentList);
        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        List<AppointmentResponse> actualAllByWaitingForDescription = appointmentServiceImpl
                .getAllByWaitingForDescription(123L, "UPCOMING");
        assertSame(appointmentResponseList, actualAllByWaitingForDescription);
        assertTrue(actualAllByWaitingForDescription.isEmpty());
        verify(appointmentRepository).findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByWaitingForDescription(Long, String)}
     */
    @Test
    void testGetAllByWaitingForDescription5() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user3.setBirthDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");

        User user4 = new User();
        user4.setActive(true);
        user4.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user4.setBirthDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        user4.setEmail("jane.doe@example.org");
        user4.setFullName("Dr Jane Doe");
        user4.setId(123L);
        user4.setPassword("iloveyou");
        user4.setPhoneNum("4105551212");
        user4.setRoles("Roles");
        user4.setSpeciality("Speciality");
        user4.setUniversityInfo("University Info");
        user4.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user4);
        pet1.setType(1);

        User user5 = new User();
        user5.setActive(true);
        user5.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user5.setBirthDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        user5.setEmail("jane.doe@example.org");
        user5.setFullName("Dr Jane Doe");
        user5.setId(123L);
        user5.setPassword("iloveyou");
        user5.setPhoneNum("4105551212");
        user5.setRoles("Roles");
        user5.setSpeciality("Speciality");
        user5.setUniversityInfo("University Info");
        user5.setUsername("janedoe");

        Appointment appointment1 = new Appointment();
        appointment1.setDate(LocalDate.ofEpochDay(1L));
        appointment1.setDescription("The characteristics of someone or something");
        appointment1.setDuration(1);
        appointment1.setId(123L);
        appointment1.setOwner(user3);
        appointment1.setPet(pet1);
        appointment1.setStatus(AppointmentStatus.UPCOMING);
        appointment1.setType(AppointmentType.REVIEWS);
        appointment1.setVet(user5);

        ArrayList<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment1);
        appointmentList.add(appointment);
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(appointmentList);
        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        List<AppointmentResponse> actualAllByWaitingForDescription = appointmentServiceImpl
                .getAllByWaitingForDescription(123L, "UPCOMING");
        assertSame(appointmentResponseList, actualAllByWaitingForDescription);
        assertTrue(actualAllByWaitingForDescription.isEmpty());
        verify(appointmentRepository).findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllByWaitingForDescription(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllByWaitingForDescription6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.time.LocalDate.isBefore(java.time.chrono.ChronoLocalDate)" because the return value of "com.example.veterinaryclinicsuperpets.entity.Appointment.getDate()" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.lambda$getAllByWaitingForDescription$1(AppointmentServiceImpl.java:132)
        //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.getAllByWaitingForDescription(AppointmentServiceImpl.java:133)
        //   In order to prevent getAllByWaitingForDescription(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllByWaitingForDescription(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user1);
        pet.setType(1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setBirthDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");
        Appointment appointment = mock(Appointment.class);
        when(appointment.getDescription()).thenReturn("The characteristics of someone or something");
        when(appointment.getDate()).thenReturn(null);
        doNothing().when(appointment).setDate((LocalDate) any());
        doNothing().when(appointment).setDescription((String) any());
        doNothing().when(appointment).setDuration(anyInt());
        doNothing().when(appointment).setId((Long) any());
        doNothing().when(appointment).setOwner((User) any());
        doNothing().when(appointment).setPet((Pet) any());
        doNothing().when(appointment).setStatus((AppointmentStatus) any());
        doNothing().when(appointment).setType((AppointmentType) any());
        doNothing().when(appointment).setVet((User) any());
        appointment.setDate(LocalDate.ofEpochDay(1L));
        appointment.setDescription("The characteristics of someone or something");
        appointment.setDuration(1);
        appointment.setId(123L);
        appointment.setOwner(user);
        appointment.setPet(pet);
        appointment.setStatus(AppointmentStatus.UPCOMING);
        appointment.setType(AppointmentType.REVIEWS);
        appointment.setVet(user2);

        ArrayList<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment);
        when(appointmentRepository.findAllByVetIdAndStatus((Long) any(), (AppointmentStatus) any()))
                .thenReturn(appointmentList);
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any())).thenReturn(new ArrayList<>());
        appointmentServiceImpl.getAllByWaitingForDescription(123L, "UPCOMING");
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllFreeTimeSlotsForDateAndVet(Long, LocalDate)}
     */
    @Test
    void testGetAllFreeTimeSlotsForDateAndVet() {
        when(appointmentRepository.findAllByVetIdAndDate((Long) any(), (LocalDate) any())).thenReturn(new ArrayList<>());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any())).thenReturn(new ArrayList<>());
        assertEquals(Short.SIZE,
                appointmentServiceImpl.getAllFreeTimeSlotsForDateAndVet(123L, LocalDate.ofEpochDay(1L)).size());
        verify(appointmentRepository).findAllByVetIdAndDate((Long) any(), (LocalDate) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllFreeTimeSlotsForDateAndVet(Long, LocalDate)}
     */
    @Test
    void testGetAllFreeTimeSlotsForDateAndVet2() {
        when(appointmentRepository.findAllByVetIdAndDate((Long) any(), (LocalDate) any())).thenReturn(new ArrayList<>());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenThrow(new IllegalArgumentException("09:00:00"));
        assertThrows(IllegalArgumentException.class,
                () -> appointmentServiceImpl.getAllFreeTimeSlotsForDateAndVet(123L, LocalDate.ofEpochDay(1L)));
        verify(appointmentRepository).findAllByVetIdAndDate((Long) any(), (LocalDate) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllFreeTimeSlotsForDateAndVet(Long, LocalDate)}
     */
    @Test
    void testGetAllFreeTimeSlotsForDateAndVet3() {
        when(appointmentRepository.findAllByVetIdAndDate((Long) any(), (LocalDate) any())).thenReturn(new ArrayList<>());

        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        appointmentResponseList.add(new AppointmentResponse());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        when(timeSlotRepository.findAllByAppointmentId((Long) any())).thenReturn(new ArrayList<>());
        assertEquals(Short.SIZE,
                appointmentServiceImpl.getAllFreeTimeSlotsForDateAndVet(123L, LocalDate.ofEpochDay(1L)).size());
        verify(appointmentRepository).findAllByVetIdAndDate((Long) any(), (LocalDate) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
        verify(timeSlotRepository).findAllByAppointmentId((Long) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllFreeTimeSlotsForDateAndVet(Long, LocalDate)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllFreeTimeSlotsForDateAndVet4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse.getId()" because "appointment" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.AppointmentServiceImpl.getAllFreeTimeSlotsForDateAndVet(AppointmentServiceImpl.java:148)
        //   In order to prevent getAllFreeTimeSlotsForDateAndVet(Long, LocalDate)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllFreeTimeSlotsForDateAndVet(Long, LocalDate).
        //   See https://diff.blue/R013 to resolve this issue.

        when(appointmentRepository.findAllByVetIdAndDate((Long) any(), (LocalDate) any())).thenReturn(new ArrayList<>());

        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        appointmentResponseList.add(null);
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        when(timeSlotRepository.findAllByAppointmentId((Long) any())).thenReturn(new ArrayList<>());
        appointmentServiceImpl.getAllFreeTimeSlotsForDateAndVet(123L, LocalDate.ofEpochDay(1L));
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllFreeTimeSlotsForDateAndVet(Long, LocalDate)}
     */
    @Test
    void testGetAllFreeTimeSlotsForDateAndVet5() {
        when(appointmentRepository.findAllByVetIdAndDate((Long) any(), (LocalDate) any())).thenReturn(new ArrayList<>());

        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        appointmentResponseList.add(new AppointmentResponse());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);

        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setAppointmentId(123L);
        timeSlot.setId(123L);
        timeSlot.setTime(LocalTime.of(Short.SIZE, 1));

        ArrayList<TimeSlot> timeSlotList = new ArrayList<>();
        timeSlotList.add(timeSlot);
        when(timeSlotRepository.findAllByAppointmentId((Long) any())).thenReturn(timeSlotList);
        assertEquals(Short.SIZE,
                appointmentServiceImpl.getAllFreeTimeSlotsForDateAndVet(123L, LocalDate.ofEpochDay(1L)).size());
        verify(appointmentRepository).findAllByVetIdAndDate((Long) any(), (LocalDate) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
        verify(timeSlotRepository).findAllByAppointmentId((Long) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllFreeTimeSlotsForDateAndVet(Long, LocalDate)}
     */
    @Test
    void testGetAllFreeTimeSlotsForDateAndVet6() {
        when(appointmentRepository.findAllByVetIdAndDate((Long) any(), (LocalDate) any())).thenReturn(new ArrayList<>());

        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        appointmentResponseList.add(new AppointmentResponse());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);

        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setAppointmentId(123L);
        timeSlot.setId(123L);
        timeSlot.setTime(LocalTime.of(Short.SIZE, 1));

        TimeSlot timeSlot1 = new TimeSlot();
        timeSlot1.setAppointmentId(123L);
        timeSlot1.setId(123L);
        timeSlot1.setTime(LocalTime.of(Short.SIZE, 1));

        ArrayList<TimeSlot> timeSlotList = new ArrayList<>();
        timeSlotList.add(timeSlot1);
        timeSlotList.add(timeSlot);
        when(timeSlotRepository.findAllByAppointmentId((Long) any())).thenReturn(timeSlotList);
        assertEquals(Short.SIZE,
                appointmentServiceImpl.getAllFreeTimeSlotsForDateAndVet(123L, LocalDate.ofEpochDay(1L)).size());
        verify(appointmentRepository).findAllByVetIdAndDate((Long) any(), (LocalDate) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
        verify(timeSlotRepository).findAllByAppointmentId((Long) any());
    }

    /**
     * Method under test: {@link AppointmentServiceImpl#getAllFreeTimeSlotsForDateAndVet(Long, LocalDate)}
     */
    @Test
    void testGetAllFreeTimeSlotsForDateAndVet7() {
        when(appointmentRepository.findAllByVetIdAndDate((Long) any(), (LocalDate) any())).thenReturn(new ArrayList<>());

        ArrayList<AppointmentResponse> appointmentResponseList = new ArrayList<>();
        appointmentResponseList.add(new AppointmentResponse());
        when(appointmentMapper.listOfEntitiesToListOfResponses((List<Appointment>) any()))
                .thenReturn(appointmentResponseList);
        when(timeSlotRepository.findAllByAppointmentId((Long) any())).thenThrow(new IllegalArgumentException("09:00:00"));
        assertThrows(IllegalArgumentException.class,
                () -> appointmentServiceImpl.getAllFreeTimeSlotsForDateAndVet(123L, LocalDate.ofEpochDay(1L)));
        verify(appointmentRepository).findAllByVetIdAndDate((Long) any(), (LocalDate) any());
        verify(appointmentMapper).listOfEntitiesToListOfResponses((List<Appointment>) any());
        verify(timeSlotRepository).findAllByAppointmentId((Long) any());
    }
}

