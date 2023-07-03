package com.example.veterinaryclinicsuperpets.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;
import com.example.veterinaryclinicsuperpets.entity.Pet;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.mapper.PetMapper;
import com.example.veterinaryclinicsuperpets.repository.PetRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PetServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PetServiceImplTest {
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
     * Method under test: {@link PetServiceImpl#getById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at com.example.veterinaryclinicsuperpets.service.impl.PetServiceImpl.getById(PetServiceImpl.java:23)
        //   In order to prevent getById(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(petRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(petMapper.entityToResponse((Pet) any())).thenReturn(new PetResponse());
        petServiceImpl.getById(123L);
    }

    /**
     * Method under test: {@link PetServiceImpl#create(PetRequest)}
     */
    @Test
    void testCreate() {
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
        assertSame(petResponse, petServiceImpl.delete(123L));
        verify(petRepository).findById((Long) any());
        verify(petRepository).delete((Pet) any());
        verify(petMapper).entityToResponse((Pet) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#delete(Long)}
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
        when(petMapper.entityToResponse((Pet) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> petServiceImpl.delete(123L));
        verify(petRepository).findById((Long) any());
        verify(petRepository).delete((Pet) any());
        verify(petMapper).entityToResponse((Pet) any());
    }

    /**
     * Method under test: {@link PetServiceImpl#delete(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDelete3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at com.example.veterinaryclinicsuperpets.service.impl.PetServiceImpl.delete(PetServiceImpl.java:35)
        //   In order to prevent delete(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(petRepository).delete((Pet) any());
        when(petRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(petMapper.entityToResponse((Pet) any())).thenReturn(new PetResponse());
        petServiceImpl.delete(123L);
    }

    /**
     * Method under test: {@link PetServiceImpl#update(PetRequest, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.PetServiceImpl.update(PetServiceImpl.java:43)
        //   In order to prevent update(PetRequest, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(PetRequest, Long).
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

        Pet pet = new Pet();
        pet.setAge(1);
        pet.setGender(3);
        pet.setId(123L);
        pet.setName("Bella");
        pet.setOwner(user);
        pet.setType(1);
        Optional<Pet> ofResult = Optional.of(pet);
        when(petRepository.findById((Long) any())).thenReturn(ofResult);
        petServiceImpl.update(new PetRequest(), 123L);
    }

    /**
     * Method under test: {@link PetServiceImpl#update(PetRequest, Long)}
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
        //       at com.example.veterinaryclinicsuperpets.service.impl.PetServiceImpl.update(PetServiceImpl.java:42)
        //   In order to prevent update(PetRequest, Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(PetRequest, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(petRepository.findById((Long) any())).thenReturn(Optional.empty());
        petServiceImpl.update(new PetRequest(), 123L);
    }

    /**
     * Method under test: {@link PetServiceImpl#update(PetRequest, Long)}
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

