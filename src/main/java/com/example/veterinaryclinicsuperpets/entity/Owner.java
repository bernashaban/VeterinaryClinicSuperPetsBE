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

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "owner")
@Entity
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String fullName;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String phoneNum;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Owner owner = (Owner) o;
    return Objects.equals(id, owner.id) && Objects.equals(email, owner.email) && Objects.equals(phoneNum, owner.phoneNum) && Objects.equals(username, owner.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, phoneNum, username);
  }
}
