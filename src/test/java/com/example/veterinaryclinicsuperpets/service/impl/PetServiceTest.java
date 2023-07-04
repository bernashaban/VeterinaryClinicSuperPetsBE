package com.example.veterinaryclinicsuperpets.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.veterinaryclinicsuperpets.dto.appointment.AppointmentResponse;
import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;
import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.mapper.PetMapper;
import com.example.veterinaryclinicsuperpets.repository.PetRepository;
import com.example.veterinaryclinicsuperpets.service.AppointmentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PetServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PetServiceTest {
    @MockBean
    private AppointmentService appointmentService;

    @MockBean
    private PetMapper petMapper;

    @MockBean
    private PetRepository petRepository;

    @Autowired
    private PetServiceImpl petServiceImpl;

    /**
     * Method under test: {@link PetServiceImpl#getById(Long)}
     */
    @Test
    void testGetById() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        Optional<Pet> ofResult = Optional.of(pet);
        when(petRepository.findById((Long) any())).thenReturn(ofResult);
        PetResponse petResponse = new PetResponse();
        when(petMapper.entityToResponse((Pet) any())).thenReturn(petResponse);
        assertSame(petResponse, petServiceImpl.getById(123L));
        verify(petRepository).findById((Long) any());
        verify(petMapper).entityToResponse((Pet) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#getById(Long)}
     */
    @Test
    void testGetById2() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        Optional<Pet> ofResult = Optional.of(pet);
        when(petRepository.findById((Long) any())).thenReturn(ofResult);
        when(petMapper.entityToResponse((Pet) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> petServiceImpl.getById(123L));
        verify(petRepository).findById((Long) any());
        verify(petMapper).entityToResponse((Pet) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#create(PetRequest)}
     */
    @Test
    void testCreate() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        when(petRepository.save((Pet) any())).thenReturn(pet);

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        user1.setBirthDate(LocalDate.ofEpochDay(1L));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user1);
        pet1.setType(1);
        when(petMapper.requestToEntity((PetRequest) any())).thenReturn(pet1);
        assertEquals(123L, petServiceImpl.create(new PetRequest()).longValue());
        verify(petRepository).save((Pet) any());
        verify(petMapper).requestToEntity((PetRequest) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#create(PetRequest)}
     */
    @Test
    void testCreate2() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        when(petRepository.save((Pet) any())).thenReturn(pet);
        when(petMapper.requestToEntity((PetRequest) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> petServiceImpl.create(new PetRequest()));
        verify(petMapper).requestToEntity((PetRequest) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#delete(Long)}
     */
    @Test
    void testDelete() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        Optional<Pet> ofResult = Optional.of(pet);
        doNothing().when(petRepository).delete((Pet) any());
        when(petRepository.findById((Long) any())).thenReturn(ofResult);
        PetResponse petResponse = new PetResponse();
        when(petMapper.entityToResponse((Pet) any())).thenReturn(petResponse);
        when(appointmentService.getAllByPet((Long) any())).thenReturn(new ArrayList<>());
        doNothing().when(appointmentService).deleteAll((List<AppointmentResponse>) any());
        assertSame(petResponse, petServiceImpl.delete(123L));
        verify(petRepository).findById((Long) any());
        verify(petRepository).delete((Pet) any());
        verify(petMapper).entityToResponse((Pet) any());
        verify(appointmentService).getAllByPet((Long) any());
        verify(appointmentService).deleteAll((List<AppointmentResponse>) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#delete(Long)}
     */
    @Test
    void testDelete2() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        Optional<Pet> ofResult = Optional.of(pet);
        doNothing().when(petRepository).delete((Pet) any());
        when(petRepository.findById((Long) any())).thenReturn(ofResult);
        when(petMapper.entityToResponse((Pet) any())).thenReturn(new PetResponse());
        when(appointmentService.getAllByPet((Long) any())).thenThrow(new IllegalArgumentException("foo"));
        doThrow(new IllegalArgumentException("foo")).when(appointmentService).deleteAll((List<AppointmentResponse>) any());
        assertThrows(IllegalArgumentException.class, () -> petServiceImpl.delete(123L));
        verify(petRepository).findById((Long) any());
        verify(appointmentService).getAllByPet((Long) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#update(PetRequest, Long)}
     */
    @Test
    void testUpdate3() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        Optional<Pet> ofResult = Optional.of(pet);

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        user1.setBirthDate(LocalDate.ofEpochDay(1L));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user1);
        pet1.setType(1);
        when(petRepository.save((Pet) any())).thenReturn(pet1);
        when(petRepository.findById((Long) any())).thenReturn(ofResult);
        PetResponse petResponse = new PetResponse();
        when(petMapper.entityToResponse((Pet) any())).thenReturn(petResponse);
        assertSame(petResponse, petServiceImpl.update(new PetRequest("Bella", 1, 1, 3, new User()), 123L));
        verify(petRepository).save((Pet) any());
        verify(petRepository).findById((Long) any());
        verify(petMapper).entityToResponse((Pet) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#update(PetRequest, Long)}
     */
    @Test
    void testUpdate4() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        Optional<Pet> ofResult = Optional.of(pet);

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        user1.setBirthDate(LocalDate.ofEpochDay(1L));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user1);
        pet1.setType(1);
        when(petRepository.save((Pet) any())).thenReturn(pet1);
        when(petRepository.findById((Long) any())).thenReturn(ofResult);
        when(petMapper.entityToResponse((Pet) any())).thenThrow(new IllegalArgumentException("Bella"));
        assertThrows(IllegalArgumentException.class,
                () -> petServiceImpl.update(new PetRequest("Bella", 1, 1, 3, new User()), 123L));
        verify(petRepository).save((Pet) any());
        verify(petRepository).findById((Long) any());
        verify(petMapper).entityToResponse((Pet) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#update(PetRequest, Long)}
     */
    @Test
    void testUpdate5() {
        User user = new User();
        user.setActive(true);
        user.setAddress("42 Main St");
        user.setBirthDate(LocalDate.ofEpochDay(1L));
        user.setEmail("jane.doe@example.org");
        user.setFullName("Dr Jane Doe");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setPhoneNum("4105551212");
        user.setRoles("Roles");
        user.setSpeciality("Speciality");
        user.setUniversityInfo("University Info");
        user.setUsername("janedoe");
        Pet pet = mock(Pet.class);
        when(pet.getAge()).thenReturn(-1);
        when(pet.getGender()).thenReturn(3);
        when(pet.getType()).thenReturn(1);
        when(pet.getName()).thenReturn("Bella");
        doNothing().when(pet).setAge(anyInt());
        doNothing().when(pet).setGender(anyInt());
        doNothing().when(pet).setId((Long) any());
        doNothing().when(pet).setName((String) any());
        doNothing().when(pet).setOwner((User) any());
        doNothing().when(pet).setType(anyInt());
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        Optional<Pet> ofResult = Optional.of(pet);

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        user1.setBirthDate(LocalDate.ofEpochDay(1L));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("Roles");
        user1.setSpeciality("Speciality");
        user1.setUniversityInfo("University Info");
        user1.setUsername("janedoe");

        Pet pet1 = new Pet();
        pet1.setAge(1);
        pet1.setGender(3);
        pet1.setId(123L);
        pet1.setName("Bella");
        pet1.setOwner(user1);
        pet1.setType(1);
        when(petRepository.save((Pet) any())).thenReturn(pet1);
        when(petRepository.findById((Long) any())).thenReturn(ofResult);
        PetResponse petResponse = new PetResponse();
        when(petMapper.entityToResponse((Pet) any())).thenReturn(petResponse);
        assertSame(petResponse, petServiceImpl.update(new PetRequest("Bella", 1, 1, 3, new User()), 123L));
        verify(petRepository).save((Pet) any());
        verify(petRepository).findById((Long) any());
        verify(pet).getAge();
        verify(pet).getGender();
        verify(pet).getType();
        verify(pet).getName();
        verify(pet, atLeast(1)).setAge(anyInt());
        verify(pet).setGender(anyInt());
        verify(pet).setId((Long) any());
        verify(pet).setName((String) any());
        verify(pet).setOwner((User) any());
        verify(pet).setType(anyInt());
        verify(petMapper).entityToResponse((Pet) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        when(petRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> petServiceImpl.getAll());
        verify(petRepository).findAll();
    }

    /**
     * Method under test: {@link PetServiceImpl#getAllByOwner(Long)}
     */
    @Test
    void testGetAllByOwner() {
        when(petRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> petServiceImpl.getAllByOwner(123L));
        verify(petRepository).findAll();
    }
}

