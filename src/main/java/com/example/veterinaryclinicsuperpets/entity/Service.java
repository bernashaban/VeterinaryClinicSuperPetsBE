package com.example.veterinaryclinicsuperpets.entity;

import com.example.veterinaryclinicsuperpets.entity.enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "service")
@Entity
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private ServiceType serviceType;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Double price;
}
