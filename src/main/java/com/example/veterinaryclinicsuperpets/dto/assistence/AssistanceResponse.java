package com.example.veterinaryclinicsuperpets.dto.assistence;

import com.example.veterinaryclinicsuperpets.entity.enums.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssistanceResponse {
  private Long id;
  private ServiceType serviceType;
  private String name;
  private Double price;
}
