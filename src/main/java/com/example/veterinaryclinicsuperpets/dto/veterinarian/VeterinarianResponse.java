package com.example.veterinaryclinicsuperpets.dto.veterinarian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeterinarianResponse {
  private Long id;
  private String fullName;
  private String speciality;
  private String universityInfo;
  private Date birthDate;
  private String photoUrl;
  private String email;
  private String username;
  private String password;
  private String phoneNum;

}
