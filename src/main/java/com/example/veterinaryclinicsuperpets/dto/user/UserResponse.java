package com.example.veterinaryclinicsuperpets.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
  private Long id;
  private String fullName;
  private String address;
  private String email;
  private String phoneNum;
  private String username;
  private String password;
  private String photoUrl;
  private boolean active;
  private String roles;
  private String speciality;
  private String universityInfo;
  private Date birthDate;
}
