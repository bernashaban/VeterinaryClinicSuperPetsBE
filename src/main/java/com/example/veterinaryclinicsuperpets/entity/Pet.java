package com.example.veterinaryclinicsuperpets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pet")
@Entity
public class Pet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private int age;

  //  CAT - 1
  //  DOG - 2
  //  RABBIT - 3
  //  OTHER - 4
  private int type;

  //1-MALE, 2-FEMALE
  private int gender;
  @ManyToOne
  private User owner;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pet pet = (Pet) o;
    return Objects.equals(id, pet.id) && Objects.equals(owner, pet.owner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, owner);
  }
}
