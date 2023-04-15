package com.example.veterinaryclinicsuperpets.entity;

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
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "veterinarian")
@Entity
public class Veterinarian {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String fullName;

  @Column(nullable = false)
  private String speciality;

  @Column(nullable = false)
  private String universityInfo;

  @Column(nullable = false)
  private Date birthDate;

  @Column(nullable = false)
  private String photoUrl;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Veterinarian that = (Veterinarian) o;
    return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(username, that.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, username);
  }
}
