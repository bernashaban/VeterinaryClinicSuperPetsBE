package com.example.veterinaryclinicsuperpets.dto.owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRequest {
  private String fullName;
  private String address;
  private String email;
  private String phoneNum;
  private String username;
  private String password;
  private String photoUrl;
}
