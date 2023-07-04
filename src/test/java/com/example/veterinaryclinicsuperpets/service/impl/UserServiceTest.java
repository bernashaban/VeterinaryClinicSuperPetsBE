package com.example.veterinaryclinicsuperpets.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.veterinaryclinicsuperpets.dto.user.UserRequest;
import com.example.veterinaryclinicsuperpets.dto.user.UserResponse;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.mapper.UserMapper;
import com.example.veterinaryclinicsuperpets.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.ValidationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private UserMapper userMapper;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#getById(Long)}
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse, userServiceImpl.getById(123L));
        verify(userRepository).findById((Long) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getById(Long)}
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        when(userMapper.entityToResponse((User) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.getById(123L));
        verify(userRepository).findById((Long) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getByUsername(String)}
     */
    @Test
    void testGetByUsername() {
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse, userServiceImpl.getByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getByUsername(String)}
     */
    @Test
    void testGetByUsername2() {
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        when(userMapper.entityToResponse((User) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.getByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#create(UserRequest)}
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
        Optional<User> ofResult = Optional.of(user1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        user2.setBirthDate(LocalDate.ofEpochDay(1L));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");
        Optional<User> ofResult1 = Optional.of(user2);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        user3.setBirthDate(LocalDate.ofEpochDay(1L));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");
        Optional<User> ofResult2 = Optional.of(user3);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(userRepository.findByPhoneNum((String) any())).thenReturn(ofResult1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult2);
        assertThrows(IllegalArgumentException.class,
                () -> userServiceImpl.create(
                        new UserRequest("janedoe", "iloveyou", "4105551212", "jane.doe@example.org", "Dr Jane Doe", "42 Main St",
                                true, "Roles", "Speciality", "University Info", "https://example.org/example", "2020-03-01")));
        verify(userRepository).findByEmail((String) any());
        verify(userRepository).findByPhoneNum((String) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#create(UserRequest)}
     */
    @Test
    void testCreate3() {
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
        Optional<User> ofResult = Optional.of(user1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        user2.setBirthDate(LocalDate.ofEpochDay(1L));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");
        Optional<User> ofResult1 = Optional.of(user2);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        when(userRepository.findByPhoneNum((String) any())).thenReturn(ofResult);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult1);
        assertThrows(IllegalArgumentException.class,
                () -> userServiceImpl.create(
                        new UserRequest("janedoe", "iloveyou", "4105551212", "jane.doe@example.org", "Dr Jane Doe", "42 Main St",
                                true, "Roles", "Speciality", "University Info", "https://example.org/example", "2020-03-01")));
        verify(userRepository).findByEmail((String) any());
        verify(userRepository).findByPhoneNum((String) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#delete(Long)}
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
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse, userServiceImpl.delete(123L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((User) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#delete(Long)}
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
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        when(userMapper.entityToResponse((User) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.delete(123L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((User) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, String)}
     */
    @Test
    void testUpdate() throws ValidationException {
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse,
                userServiceImpl.update(
                        new UserRequest("janedoe", "iloveyou", "4105551212", "jane.doe@example.org", "Dr Jane Doe", "42 Main St",
                                true, "Roles", "Speciality", "University Info", "https://example.org/example", "2020-03-01"),
                        "janedoe"));
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, String)}
     */
    @Test
    void testUpdate2() throws ValidationException {
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        when(userMapper.entityToResponse((User) any())).thenThrow(new IllegalArgumentException("Dr Jane Doe"));
        assertThrows(IllegalArgumentException.class,
                () -> userServiceImpl.update(
                        new UserRequest("janedoe", "iloveyou", "4105551212", "jane.doe@example.org", "Dr Jane Doe", "42 Main St",
                                true, "Roles", "Speciality", "University Info", "https://example.org/example", "2020-03-01"),
                        "janedoe"));
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, String)}
     */
    @Test
    void testUpdate3() throws ValidationException {
        User user = mock(User.class);
        when(user.isActive()).thenReturn(true);
        when(user.getRoles()).thenReturn("Roles");
        doNothing().when(user).setPhotoUrl((String) any());
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getPhoneNum()).thenReturn("4105551212");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getAddress()).thenReturn("42 Main St");
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getFullName()).thenReturn("Dr Jane Doe");
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setBirthDate((LocalDate) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFullName((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setPhoneNum((String) any());
        doNothing().when(user).setRoles((String) any());
        doNothing().when(user).setSpeciality((String) any());
        doNothing().when(user).setUniversityInfo((String) any());
        doNothing().when(user).setUsername((String) any());
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
        Optional<User> ofResult = Optional.of(user);

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

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        user2.setBirthDate(LocalDate.ofEpochDay(1L));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");
        Optional<User> ofResult1 = Optional.of(user2);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        user3.setBirthDate(LocalDate.ofEpochDay(1L));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");
        Optional<User> ofResult2 = Optional.of(user3);
        when(userRepository.findByPhoneNum((String) any())).thenReturn(ofResult2);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult1);
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse,
                userServiceImpl.update(
                        new UserRequest("janedoe", "iloveyou", "4105551212", "jane.doe@example.org", "Dr Jane Doe", "42 Main St",
                                true, "Roles", "Speciality", "University Info", "https://example.org/example", "2020-03-01"),
                        "janedoe"));
        verify(userRepository).save((User) any());
        verify(userRepository).findByUsername((String) any());
        verify(user).isActive();
        verify(user).getAddress();
        verify(user).getEmail();
        verify(user, atLeast(1)).getFullName();
        verify(user).getPassword();
        verify(user).getPhoneNum();
        verify(user).getRoles();
        verify(user).getUsername();
        verify(user).setActive(anyBoolean());
        verify(user).setAddress((String) any());
        verify(user, atLeast(1)).setBirthDate((LocalDate) any());
        verify(user).setEmail((String) any());
        verify(user).setFullName((String) any());
        verify(user).setId((Long) any());
        verify(user).setPassword((String) any());
        verify(user).setPhoneNum((String) any());
        verify(user).setPhotoUrl((String) any());
        verify(user).setRoles((String) any());
        verify(user, atLeast(1)).setSpeciality((String) any());
        verify(user, atLeast(1)).setUniversityInfo((String) any());
        verify(user).setUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, String)}
     */
    @Test
    void testUpdate4() throws ValidationException {
        User user = mock(User.class);
        when(user.isActive()).thenThrow(new ValidationException("An error occurred"));
        when(user.getRoles()).thenThrow(new ValidationException("An error occurred"));
        doThrow(new ValidationException("An error occurred")).when(user).setPhotoUrl((String) any());
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getPhoneNum()).thenReturn("4105551212");
        when(user.getUsername()).thenReturn("janedoe");
        when(user.getAddress()).thenReturn("42 Main St");
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getFullName()).thenReturn("Dr Jane Doe");
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setBirthDate((LocalDate) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFullName((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setPhoneNum((String) any());
        doNothing().when(user).setRoles((String) any());
        doNothing().when(user).setSpeciality((String) any());
        doNothing().when(user).setUniversityInfo((String) any());
        doNothing().when(user).setUsername((String) any());
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
        Optional<User> ofResult = Optional.of(user);

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

        User user2 = new User();
        user2.setActive(true);
        user2.setAddress("42 Main St");
        user2.setBirthDate(LocalDate.ofEpochDay(1L));
        user2.setEmail("jane.doe@example.org");
        user2.setFullName("Dr Jane Doe");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setPhoneNum("4105551212");
        user2.setRoles("Roles");
        user2.setSpeciality("Speciality");
        user2.setUniversityInfo("University Info");
        user2.setUsername("janedoe");
        Optional<User> ofResult1 = Optional.of(user2);

        User user3 = new User();
        user3.setActive(true);
        user3.setAddress("42 Main St");
        user3.setBirthDate(LocalDate.ofEpochDay(1L));
        user3.setEmail("jane.doe@example.org");
        user3.setFullName("Dr Jane Doe");
        user3.setId(123L);
        user3.setPassword("iloveyou");
        user3.setPhoneNum("4105551212");
        user3.setRoles("Roles");
        user3.setSpeciality("Speciality");
        user3.setUniversityInfo("University Info");
        user3.setUsername("janedoe");
        Optional<User> ofResult2 = Optional.of(user3);
        when(userRepository.findByPhoneNum((String) any())).thenReturn(ofResult2);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult1);
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        when(userMapper.entityToResponse((User) any())).thenReturn(new UserResponse());
        assertThrows(ValidationException.class,
                () -> userServiceImpl.update(
                        new UserRequest("janedoe", "iloveyou", "4105551212", "jane.doe@example.org", "Dr Jane Doe", "42 Main St",
                                true, "Roles", "Speciality", "University Info", "https://example.org/example", "2020-03-01"),
                        "janedoe"));
        verify(userRepository).findByUsername((String) any());
        verify(user).getAddress();
        verify(user).getEmail();
        verify(user).getFullName();
        verify(user).getPassword();
        verify(user).getPhoneNum();
        verify(user).getRoles();
        verify(user).getUsername();
        verify(user).setActive(anyBoolean());
        verify(user).setAddress((String) any());
        verify(user).setBirthDate((LocalDate) any());
        verify(user).setEmail((String) any());
        verify(user).setFullName((String) any());
        verify(user).setId((Long) any());
        verify(user).setPassword((String) any());
        verify(user).setPhoneNum((String) any());
        verify(user).setRoles((String) any());
        verify(user).setSpeciality((String) any());
        verify(user).setUniversityInfo((String) any());
        verify(user).setUsername((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        ArrayList<UserResponse> userResponseList = new ArrayList<>();
        when(userMapper.listOfEntitiesToListOfResponses((List<User>) any())).thenReturn(userResponseList);
        List<UserResponse> actualAll = userServiceImpl.getAll();
        assertSame(userResponseList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(userRepository).findAll();
        verify(userMapper).listOfEntitiesToListOfResponses((List<User>) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAll()}
     */
    @Test
    void testGetAll2() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        when(userMapper.listOfEntitiesToListOfResponses((List<User>) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.getAll());
        verify(userRepository).findAll();
        verify(userMapper).listOfEntitiesToListOfResponses((List<User>) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllVets()}
     */
    @Test
    void testGetAllVets() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        ArrayList<UserResponse> userResponseList = new ArrayList<>();
        when(userMapper.listOfEntitiesToListOfResponses((List<User>) any())).thenReturn(userResponseList);
        List<UserResponse> actualAllVets = userServiceImpl.getAllVets();
        assertSame(userResponseList, actualAllVets);
        assertTrue(actualAllVets.isEmpty());
        verify(userRepository).findAll();
        verify(userMapper).listOfEntitiesToListOfResponses((List<User>) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllVets()}
     */
    @Test
    void testGetAllVets2() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        when(userMapper.listOfEntitiesToListOfResponses((List<User>) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.getAllVets());
        verify(userRepository).findAll();
        verify(userMapper).listOfEntitiesToListOfResponses((List<User>) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllVets()}
     */
    @Test
    void testGetAllVets3() {
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

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        ArrayList<UserResponse> userResponseList = new ArrayList<>();
        when(userMapper.listOfEntitiesToListOfResponses((List<User>) any())).thenReturn(userResponseList);
        List<UserResponse> actualAllVets = userServiceImpl.getAllVets();
        assertSame(userResponseList, actualAllVets);
        assertTrue(actualAllVets.isEmpty());
        verify(userRepository).findAll();
        verify(userMapper).listOfEntitiesToListOfResponses((List<User>) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllVets()}
     */
    @Test
    void testGetAllVets4() {
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

        User user1 = new User();
        user1.setActive(true);
        user1.setAddress("42 Main St");
        user1.setBirthDate(LocalDate.ofEpochDay(1L));
        user1.setEmail("jane.doe@example.org");
        user1.setFullName("Dr Jane Doe");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setPhoneNum("4105551212");
        user1.setRoles("ROLE_VET");
        user1.setSpeciality("ROLE_VET");
        user1.setUniversityInfo("ROLE_VET");
        user1.setUsername("janedoe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        ArrayList<UserResponse> userResponseList = new ArrayList<>();
        when(userMapper.listOfEntitiesToListOfResponses((List<User>) any())).thenReturn(userResponseList);
        List<UserResponse> actualAllVets = userServiceImpl.getAllVets();
        assertSame(userResponseList, actualAllVets);
        assertTrue(actualAllVets.isEmpty());
        verify(userRepository).findAll();
        verify(userMapper).listOfEntitiesToListOfResponses((List<User>) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getAllVets()}
     */
    @Test
    void testGetAllVets5() {
        User user = mock(User.class);
        when(user.getRoles()).thenReturn("Roles");
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setBirthDate((LocalDate) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setFullName((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setPhoneNum((String) any());
        doNothing().when(user).setRoles((String) any());
        doNothing().when(user).setSpeciality((String) any());
        doNothing().when(user).setUniversityInfo((String) any());
        doNothing().when(user).setUsername((String) any());
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

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        ArrayList<UserResponse> userResponseList = new ArrayList<>();
        when(userMapper.listOfEntitiesToListOfResponses((List<User>) any())).thenReturn(userResponseList);
        List<UserResponse> actualAllVets = userServiceImpl.getAllVets();
        assertSame(userResponseList, actualAllVets);
        assertTrue(actualAllVets.isEmpty());
        verify(userRepository).findAll();
        verify(user).getRoles();
        verify(user).setActive(anyBoolean());
        verify(user).setAddress((String) any());
        verify(user).setBirthDate((LocalDate) any());
        verify(user).setEmail((String) any());
        verify(user).setFullName((String) any());
        verify(user).setId((Long) any());
        verify(user).setPassword((String) any());
        verify(user).setPhoneNum((String) any());
        verify(user).setRoles((String) any());
        verify(user).setSpeciality((String) any());
        verify(user).setUniversityInfo((String) any());
        verify(user).setUsername((String) any());
        verify(userMapper).listOfEntitiesToListOfResponses((List<User>) any());
    }
}

