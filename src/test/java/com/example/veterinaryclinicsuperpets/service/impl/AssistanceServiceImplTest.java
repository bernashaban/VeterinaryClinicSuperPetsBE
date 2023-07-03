package com.example.veterinaryclinicsuperpets.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceRequest;
import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceResponse;
import com.example.veterinaryclinicsuperpets.entity.Assistance;
import com.example.veterinaryclinicsuperpets.entity.enums.ServiceType;
import com.example.veterinaryclinicsuperpets.mapper.AssistanceMapper;
import com.example.veterinaryclinicsuperpets.repository.AssistanceRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AssistanceServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AssistanceServiceImplTest {
    @MockBean
    private AssistanceMapper assistanceMapper;

    @MockBean
    private AssistanceRepository assistanceRepository;

    @Autowired
    private AssistanceServiceImpl assistanceServiceImpl;

    /**
     * Method under test: {@link AssistanceServiceImpl#getById(Long)}
     */
    @Test
    void testGetById() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        AssistanceResponse assistanceResponse = new AssistanceResponse();
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(assistanceResponse);
        assertSame(assistanceResponse, assistanceServiceImpl.getById(123L));
        verify(assistanceRepository).findById((Long) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#getById(Long)}
     */
    @Test
    void testGetById2() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        when(assistanceMapper.entityToResponse((Assistance) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> assistanceServiceImpl.getById(123L));
        verify(assistanceRepository).findById((Long) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#getById(Long)}
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
        //       at com.example.veterinaryclinicsuperpets.service.impl.AssistanceServiceImpl.getById(AssistanceServiceImpl.java:24)
        //   In order to prevent getById(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(assistanceRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(new AssistanceResponse());
        assistanceServiceImpl.getById(123L);
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#create(AssistanceRequest)}
     */
    @Test
    void testCreate() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance);

        Assistance assistance1 = new Assistance();
        assistance1.setId(123L);
        assistance1.setName("Bella");
        assistance1.setPrice(10.0d);
        assistance1.setServiceType(ServiceType.REVIEWS);
        when(assistanceMapper.requestToEntity((AssistanceRequest) any())).thenReturn(assistance1);
        assertEquals(123L, assistanceServiceImpl.create(new AssistanceRequest()).longValue());
        verify(assistanceRepository).save((Assistance) any());
        verify(assistanceMapper).requestToEntity((AssistanceRequest) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#create(AssistanceRequest)}
     */
    @Test
    void testCreate2() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance);
        when(assistanceMapper.requestToEntity((AssistanceRequest) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> assistanceServiceImpl.create(new AssistanceRequest()));
        verify(assistanceMapper).requestToEntity((AssistanceRequest) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#delete(Long)}
     */
    @Test
    void testDelete() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);
        doNothing().when(assistanceRepository).delete((Assistance) any());
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        AssistanceResponse assistanceResponse = new AssistanceResponse();
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(assistanceResponse);
        assertSame(assistanceResponse, assistanceServiceImpl.delete(123L));
        verify(assistanceRepository).findById((Long) any());
        verify(assistanceRepository).delete((Assistance) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#delete(Long)}
     */
    @Test
    void testDelete2() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);
        doNothing().when(assistanceRepository).delete((Assistance) any());
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        when(assistanceMapper.entityToResponse((Assistance) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> assistanceServiceImpl.delete(123L));
        verify(assistanceRepository).findById((Long) any());
        verify(assistanceRepository).delete((Assistance) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#delete(Long)}
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
        //       at com.example.veterinaryclinicsuperpets.service.impl.AssistanceServiceImpl.delete(AssistanceServiceImpl.java:37)
        //   In order to prevent delete(Long)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(assistanceRepository).delete((Assistance) any());
        when(assistanceRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(new AssistanceResponse());
        assistanceServiceImpl.delete(123L);
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#update(AssistanceRequest, Long)}
     */
    @Test
    void testUpdate() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);

        Assistance assistance1 = new Assistance();
        assistance1.setId(123L);
        assistance1.setName("Bella");
        assistance1.setPrice(10.0d);
        assistance1.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance1);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        AssistanceResponse assistanceResponse = new AssistanceResponse();
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(assistanceResponse);
        assertSame(assistanceResponse, assistanceServiceImpl.update(new AssistanceRequest(), 123L));
        verify(assistanceRepository).save((Assistance) any());
        verify(assistanceRepository).findById((Long) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#update(AssistanceRequest, Long)}
     */
    @Test
    void testUpdate2() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);

        Assistance assistance1 = new Assistance();
        assistance1.setId(123L);
        assistance1.setName("Bella");
        assistance1.setPrice(10.0d);
        assistance1.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance1);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        when(assistanceMapper.entityToResponse((Assistance) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> assistanceServiceImpl.update(new AssistanceRequest(), 123L));
        verify(assistanceRepository).save((Assistance) any());
        verify(assistanceRepository).findById((Long) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#update(AssistanceRequest, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.orElseThrow(java.util.function.Supplier)" because the return value of "com.example.veterinaryclinicsuperpets.repository.AssistanceRepository.findById(Object)" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.AssistanceServiceImpl.update(AssistanceServiceImpl.java:45)
        //   In order to prevent update(AssistanceRequest, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(AssistanceRequest, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance);
        when(assistanceRepository.findById((Long) any())).thenReturn(null);
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(new AssistanceResponse());
        assistanceServiceImpl.update(new AssistanceRequest(), 123L);
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#update(AssistanceRequest, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceRequest.getName()" because "request" is null
        //       at com.example.veterinaryclinicsuperpets.service.impl.AssistanceServiceImpl.update(AssistanceServiceImpl.java:46)
        //   In order to prevent update(AssistanceRequest, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(AssistanceRequest, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);

        Assistance assistance1 = new Assistance();
        assistance1.setId(123L);
        assistance1.setName("Bella");
        assistance1.setPrice(10.0d);
        assistance1.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance1);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(new AssistanceResponse());
        assistanceServiceImpl.update(null, 123L);
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#update(AssistanceRequest, Long)}
     */
    @Test
    void testUpdate5() {
        Assistance assistance = new Assistance();
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);

        Assistance assistance1 = new Assistance();
        assistance1.setId(123L);
        assistance1.setName("Bella");
        assistance1.setPrice(10.0d);
        assistance1.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance1);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        AssistanceResponse assistanceResponse = new AssistanceResponse();
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(assistanceResponse);
        assertSame(assistanceResponse,
                assistanceServiceImpl.update(new AssistanceRequest(ServiceType.REVIEWS, "Bella", 10.0d), 123L));
        verify(assistanceRepository).save((Assistance) any());
        verify(assistanceRepository).findById((Long) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#update(AssistanceRequest, Long)}
     */
    @Test
    void testUpdate6() {
        Assistance assistance = mock(Assistance.class);
        when(assistance.getServiceType()).thenReturn(ServiceType.PREVENTIVE);
        when(assistance.getPrice()).thenReturn(10.0d);
        when(assistance.getName()).thenReturn("Bella");
        doNothing().when(assistance).setId((Long) any());
        doNothing().when(assistance).setName((String) any());
        doNothing().when(assistance).setPrice((Double) any());
        doNothing().when(assistance).setServiceType((ServiceType) any());
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);

        Assistance assistance1 = new Assistance();
        assistance1.setId(123L);
        assistance1.setName("Bella");
        assistance1.setPrice(10.0d);
        assistance1.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance1);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        AssistanceResponse assistanceResponse = new AssistanceResponse();
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(assistanceResponse);
        AssistanceRequest assistanceRequest = mock(AssistanceRequest.class);
        when(assistanceRequest.getServiceType()).thenReturn(ServiceType.REVIEWS);
        when(assistanceRequest.getPrice()).thenReturn(10.0d);
        when(assistanceRequest.getName()).thenReturn("Bella");
        assertSame(assistanceResponse, assistanceServiceImpl.update(assistanceRequest, 123L));
        verify(assistanceRepository).save((Assistance) any());
        verify(assistanceRepository).findById((Long) any());
        verify(assistance).getServiceType();
        verify(assistance).getPrice();
        verify(assistance).getName();
        verify(assistance).setId((Long) any());
        verify(assistance).setName((String) any());
        verify(assistance).setPrice((Double) any());
        verify(assistance, atLeast(1)).setServiceType((ServiceType) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
        verify(assistanceRequest, atLeast(1)).getServiceType();
        verify(assistanceRequest, atLeast(1)).getPrice();
        verify(assistanceRequest, atLeast(1)).getName();
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#update(AssistanceRequest, Long)}
     */
    @Test
    void testUpdate7() {
        Assistance assistance = mock(Assistance.class);
        when(assistance.getServiceType()).thenReturn(ServiceType.REVIEWS);
        when(assistance.getPrice()).thenReturn(0.5d);
        when(assistance.getName()).thenReturn("Bella");
        doNothing().when(assistance).setId((Long) any());
        doNothing().when(assistance).setName((String) any());
        doNothing().when(assistance).setPrice((Double) any());
        doNothing().when(assistance).setServiceType((ServiceType) any());
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);

        Assistance assistance1 = new Assistance();
        assistance1.setId(123L);
        assistance1.setName("Bella");
        assistance1.setPrice(10.0d);
        assistance1.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance1);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        AssistanceResponse assistanceResponse = new AssistanceResponse();
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(assistanceResponse);
        AssistanceRequest assistanceRequest = mock(AssistanceRequest.class);
        when(assistanceRequest.getServiceType()).thenReturn(ServiceType.REVIEWS);
        when(assistanceRequest.getPrice()).thenReturn(10.0d);
        when(assistanceRequest.getName()).thenReturn("Bella");
        assertSame(assistanceResponse, assistanceServiceImpl.update(assistanceRequest, 123L));
        verify(assistanceRepository).save((Assistance) any());
        verify(assistanceRepository).findById((Long) any());
        verify(assistance).getServiceType();
        verify(assistance).getPrice();
        verify(assistance).getName();
        verify(assistance).setId((Long) any());
        verify(assistance).setName((String) any());
        verify(assistance, atLeast(1)).setPrice((Double) any());
        verify(assistance).setServiceType((ServiceType) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
        verify(assistanceRequest, atLeast(1)).getServiceType();
        verify(assistanceRequest, atLeast(1)).getPrice();
        verify(assistanceRequest, atLeast(1)).getName();
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#update(AssistanceRequest, Long)}
     */
    @Test
    void testUpdate8() {
        Assistance assistance = mock(Assistance.class);
        when(assistance.getServiceType()).thenReturn(ServiceType.REVIEWS);
        when(assistance.getPrice()).thenReturn(10.0d);
        when(assistance.getName()).thenReturn("foo");
        doNothing().when(assistance).setId((Long) any());
        doNothing().when(assistance).setName((String) any());
        doNothing().when(assistance).setPrice((Double) any());
        doNothing().when(assistance).setServiceType((ServiceType) any());
        assistance.setId(123L);
        assistance.setName("Bella");
        assistance.setPrice(10.0d);
        assistance.setServiceType(ServiceType.REVIEWS);
        Optional<Assistance> ofResult = Optional.of(assistance);

        Assistance assistance1 = new Assistance();
        assistance1.setId(123L);
        assistance1.setName("Bella");
        assistance1.setPrice(10.0d);
        assistance1.setServiceType(ServiceType.REVIEWS);
        when(assistanceRepository.save((Assistance) any())).thenReturn(assistance1);
        when(assistanceRepository.findById((Long) any())).thenReturn(ofResult);
        AssistanceResponse assistanceResponse = new AssistanceResponse();
        when(assistanceMapper.entityToResponse((Assistance) any())).thenReturn(assistanceResponse);
        AssistanceRequest assistanceRequest = mock(AssistanceRequest.class);
        when(assistanceRequest.getServiceType()).thenReturn(ServiceType.REVIEWS);
        when(assistanceRequest.getPrice()).thenReturn(10.0d);
        when(assistanceRequest.getName()).thenReturn("Bella");
        assertSame(assistanceResponse, assistanceServiceImpl.update(assistanceRequest, 123L));
        verify(assistanceRepository).save((Assistance) any());
        verify(assistanceRepository).findById((Long) any());
        verify(assistance).getServiceType();
        verify(assistance).getPrice();
        verify(assistance).getName();
        verify(assistance).setId((Long) any());
        verify(assistance, atLeast(1)).setName((String) any());
        verify(assistance).setPrice((Double) any());
        verify(assistance).setServiceType((ServiceType) any());
        verify(assistanceMapper).entityToResponse((Assistance) any());
        verify(assistanceRequest, atLeast(1)).getServiceType();
        verify(assistanceRequest, atLeast(1)).getPrice();
        verify(assistanceRequest, atLeast(1)).getName();
    }

    /**
     * Method under test: {@link AssistanceServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        when(assistanceRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> assistanceServiceImpl.getAll());
        verify(assistanceRepository).findAll();
    }
}

