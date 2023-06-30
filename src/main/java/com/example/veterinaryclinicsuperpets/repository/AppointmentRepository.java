package com.example.veterinaryclinicsuperpets.repository;

import com.example.veterinaryclinicsuperpets.entity.Appointment;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findAllByVetIdAndDate(Long Id, LocalDate date);
    List<Appointment> findAllByVetIdAndStatus(Long Id, AppointmentStatus status);
    List<Appointment> findAllByOwnerIdAndStatus(Long Id, AppointmentStatus status);
}
