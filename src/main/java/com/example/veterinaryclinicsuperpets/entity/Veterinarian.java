package com.example.veterinaryclinicsuperpets.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "veterinarian")
@Entity
public class Veterinarian extends User{

  private String fullName;
  private String speciality;
  private String universityInfo;
  private Date birthDate;
  private String photoUrl;

}
