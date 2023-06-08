package com.example.veterinaryclinicsuperpets.repository;

import com.example.veterinaryclinicsuperpets.entity.Owner;
import com.example.veterinaryclinicsuperpets.entity.Veterinarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeterinarianRepository extends CrudRepository<Veterinarian, Long> {
    Optional<Veterinarian> findByUsername(String username);
    Veterinarian findByEmail(String email);
    Veterinarian findByPhoneNum(String phoneNum);
}
