package com.example.veterinaryclinicsuperpets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "USERS")
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String username;
  private String password;
  private String phoneNum;
  private boolean active;
  private String roles;
  private String email;
  private String fullName;
  private String address;
  private String photoUrl;
  //only for vet
  private String speciality;
  private String universityInfo;
  private Date birthDate;

}
