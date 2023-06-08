package com.example.veterinaryclinicsuperpets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
}