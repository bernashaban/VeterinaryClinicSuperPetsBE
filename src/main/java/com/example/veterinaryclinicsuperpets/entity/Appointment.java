package com.example.veterinaryclinicsuperpets.entity;

import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentStatus;
import com.example.veterinaryclinicsuperpets.entity.enums.AppointmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "appointment")
@Entity
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private User owner;
  @ManyToOne private Pet pet;
  @ManyToOne private User vet;

  @Column(nullable = false)
  private LocalDate date;

  @Column
  private String description;

  @Column
  private int duration;

  @Enumerated(EnumType.STRING)
  private AppointmentStatus status;

  @Enumerated(EnumType.STRING)
  private AppointmentType type;
}
