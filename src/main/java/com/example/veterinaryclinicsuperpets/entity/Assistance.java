package com.example.veterinaryclinicsuperpets.entity;

import com.example.veterinaryclinicsuperpets.entity.enums.ServiceType;
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
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "service")
@Entity
public class Assistance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private ServiceType serviceType;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Double price;
}
