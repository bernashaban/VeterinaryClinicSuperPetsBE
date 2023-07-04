package com.example.veterinaryclinicsuperpets.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  private String username;
  private String password;
  private String phoneNum;
  private String email;
  private String fullName;
  private String address;
  private boolean active;
  private String roles;

  private String speciality;
  private String universityInfo;
  private String photoUrl;
  private String birthDate;

  public boolean isActive() {
    return active;
  }
}
