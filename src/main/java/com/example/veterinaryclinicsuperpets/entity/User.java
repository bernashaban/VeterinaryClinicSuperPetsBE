package com.example.veterinaryclinicsuperpets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String phoneNum;

  @Column(nullable = false)
  private boolean active;

  @Column(nullable = false)
  private String roles;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String fullName;

  @Column(nullable = false)
  private String address;

  //only for vet
  private String photoUrl;
  private String speciality;
  private String universityInfo;
  private Date birthDate;

  public boolean isActive() {
    return active;
  }
}
