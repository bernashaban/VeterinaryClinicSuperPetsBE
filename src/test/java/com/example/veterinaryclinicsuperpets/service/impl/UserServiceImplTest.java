package com.example.veterinaryclinicsuperpets.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.veterinaryclinicsuperpets.dto.user.UserRequest;
import com.example.veterinaryclinicsuperpets.dto.user.UserResponse;
import com.example.veterinaryclinicsuperpets.entity.User;
import com.example.veterinaryclinicsuperpets.mapper.UserMapper;
import com.example.veterinaryclinicsuperpets.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserMapper userMapper;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @MockBean
    private Validator validator;

    /**
     * Method under test: {@link UserServiceImpl#getById(Long)}
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        when(userMapper.entityToResponse((User) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.getById(123L));
        verify(userRepository).findById((Long) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getById(Long)}
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
        //       at com.example.veterinaryclinicsuperpets.service.impl.UserServiceImpl.getById(UserServiceImpl.java:28)
        //   In order to prevent getById(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(userMapper.entityToResponse((User) any())).thenReturn(new UserResponse());
        userServiceImpl.getById(123L);
    }

    /**
     * Method under test: {@link UserServiceImpl#getByUsername(String)}
     */
    @Test
    void testGetByUsername() {
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
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        when(userMapper.entityToResponse((User) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.getByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetByUsername3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at com.example.veterinaryclinicsuperpets.service.impl.UserServiceImpl.getByUsername(UserServiceImpl.java:34)
        //   In order to prevent getByUsername(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        when(userMapper.entityToResponse((User) any())).thenReturn(new UserResponse());
        userServiceImpl.getByUsername("janedoe");
    }

    /**
     * Method under test: {@link UserServiceImpl#create(UserRequest)}
     */
    @Test
    void testCreate() throws IllegalArgumentException {
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
        Optional<User> ofResult = Optional.of(user1);

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
        Optional<User> ofResult1 = Optional.of(user2);

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
        Optional<User> ofResult2 = Optional.of(user3);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(userRepository.findByPhoneNum((String) any())).thenReturn(ofResult1);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult2);
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.create(new UserRequest("janedoe", "iloveyou",
                "4105551212", "jane.doe@example.org", "Dr Jane Doe", "42 Main St", true, "Roles")));
        verify(userRepository).findByEmail((String) any());
        verify(userRepository).findByPhoneNum((String) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#create(UserRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreate2() throws IllegalArgumentException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.orElse(Object)" because the return value of "com.example.veterinaryclinicsuperpets.repository.UserRepository.findByEmail(String)" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.UserServiceImpl.create(UserServiceImpl.java:41)
        //   In order to prevent create(UserRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   create(UserRequest).
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
        Optional<User> ofResult = Optional.of(user1);

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
        Optional<User> ofResult1 = Optional.of(user2);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByEmail((String) any())).thenReturn(null);
        when(userRepository.findByPhoneNum((String) any())).thenReturn(ofResult);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult1);
        userServiceImpl.create(new UserRequest("janedoe", "iloveyou", "4105551212", "jane.doe@example.org", "Dr Jane Doe",
                "42 Main St", true, "Roles"));
    }

    /**
     * Method under test: {@link UserServiceImpl#delete(Long)}
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
     * Method under test: {@link UserServiceImpl#delete(Long)}
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
        //       at com.example.veterinaryclinicsuperpets.service.impl.UserServiceImpl.delete(UserServiceImpl.java:72)
        //   In order to prevent delete(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(userMapper.entityToResponse((User) any())).thenReturn(new UserResponse());
        userServiceImpl.delete(123L);
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, Long)}
     */
    @Test
    void testUpdate() throws ValidationException {
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse, userServiceImpl.update(new UserRequest("janedoe", "iloveyou", "4105551212",
                "jane.doe@example.org", "Dr Jane Doe", "42 Main St", true, "Roles"), 123L));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, Long)}
     */
    @Test
    void testUpdate2() throws ValidationException {
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        when(userMapper.entityToResponse((User) any())).thenThrow(new IllegalArgumentException("Dr Jane Doe"));
        assertThrows(IllegalArgumentException.class, () -> userServiceImpl.update(new UserRequest("janedoe", "iloveyou",
                "4105551212", "jane.doe@example.org", "Dr Jane Doe", "42 Main St", true, "Roles"), 123L));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, Long)}
     */
    @Test
    void testUpdate3() throws ValidationException {
        User user = mock(User.class);
        when(user.isActive()).thenReturn(false);
        when(user.getAddress()).thenReturn("42 Main St");
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getFullName()).thenReturn("Dr Jane Doe");
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setBirthDate((Date) any());
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse, userServiceImpl.update(new UserRequest("janedoe", "iloveyou", "4105551212",
                "jane.doe@example.org", "Dr Jane Doe", "42 Main St", true, "Roles"), 123L));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).isActive();
        verify(user).getAddress();
        verify(user).getEmail();
        verify(user).getFullName();
        verify(user, atLeast(1)).setActive(anyBoolean());
        verify(user).setAddress((String) any());
        verify(user).setBirthDate((Date) any());
        verify(user).setEmail((String) any());
        verify(user).setFullName((String) any());
        verify(user).setId((Long) any());
        verify(user).setPassword((String) any());
        verify(user).setPhoneNum((String) any());
        verify(user).setRoles((String) any());
        verify(user).setSpeciality((String) any());
        verify(user).setUniversityInfo((String) any());
        verify(user).setUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, Long)}
     */
    @Test
    void testUpdate4() throws ValidationException {
        User user = mock(User.class);
        when(user.isActive()).thenReturn(true);
        when(user.getAddress()).thenReturn("foo");
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getFullName()).thenReturn("Dr Jane Doe");
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setBirthDate((Date) any());
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse, userServiceImpl.update(new UserRequest("janedoe", "iloveyou", "4105551212",
                "jane.doe@example.org", "Dr Jane Doe", "42 Main St", true, "Roles"), 123L));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).isActive();
        verify(user).getAddress();
        verify(user).getEmail();
        verify(user).getFullName();
        verify(user).setActive(anyBoolean());
        verify(user, atLeast(1)).setAddress((String) any());
        verify(user).setBirthDate((Date) any());
        verify(user).setEmail((String) any());
        verify(user).setFullName((String) any());
        verify(user).setId((Long) any());
        verify(user).setPassword((String) any());
        verify(user).setPhoneNum((String) any());
        verify(user).setRoles((String) any());
        verify(user).setSpeciality((String) any());
        verify(user).setUniversityInfo((String) any());
        verify(user).setUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, Long)}
     */
    @Test
    void testUpdate5() throws ValidationException {
        User user = mock(User.class);
        when(user.isActive()).thenReturn(true);
        when(user.getAddress()).thenReturn("42 Main St");
        when(user.getEmail()).thenReturn("foo");
        when(user.getFullName()).thenReturn("Dr Jane Doe");
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setBirthDate((Date) any());
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse, userServiceImpl.update(new UserRequest("janedoe", "iloveyou", "4105551212",
                "jane.doe@example.org", "Dr Jane Doe", "42 Main St", true, "Roles"), 123L));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).isActive();
        verify(user).getAddress();
        verify(user).getEmail();
        verify(user).getFullName();
        verify(user).setActive(anyBoolean());
        verify(user).setAddress((String) any());
        verify(user).setBirthDate((Date) any());
        verify(user, atLeast(1)).setEmail((String) any());
        verify(user).setFullName((String) any());
        verify(user).setId((Long) any());
        verify(user).setPassword((String) any());
        verify(user).setPhoneNum((String) any());
        verify(user).setRoles((String) any());
        verify(user).setSpeciality((String) any());
        verify(user).setUniversityInfo((String) any());
        verify(user).setUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#update(UserRequest, Long)}
     */
    @Test
    void testUpdate6() throws ValidationException {
        User user = mock(User.class);
        when(user.isActive()).thenReturn(true);
        when(user.getAddress()).thenReturn("42 Main St");
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getFullName()).thenReturn("foo");
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setAddress((String) any());
        doNothing().when(user).setBirthDate((Date) any());
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
        Optional<User> ofResult = Optional.of(user);

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
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        UserResponse userResponse = new UserResponse();
        when(userMapper.entityToResponse((User) any())).thenReturn(userResponse);
        assertSame(userResponse, userServiceImpl.update(new UserRequest("janedoe", "iloveyou", "4105551212",
                "jane.doe@example.org", "Dr Jane Doe", "42 Main St", true, "Roles"), 123L));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).isActive();
        verify(user).getAddress();
        verify(user).getEmail();
        verify(user).getFullName();
        verify(user).setActive(anyBoolean());
        verify(user).setAddress((String) any());
        verify(user).setBirthDate((Date) any());
        verify(user).setEmail((String) any());
        verify(user, atLeast(1)).setFullName((String) any());
        verify(user).setId((Long) any());
        verify(user).setPassword((String) any());
        verify(user).setPhoneNum((String) any());
        verify(user).setRoles((String) any());
        verify(user).setSpeciality((String) any());
        verify(user).setUniversityInfo((String) any());
        verify(user).setUsername((String) any());
        verify(userMapper).entityToResponse((User) any());
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
}

