package com.example.veterinaryclinicsuperpets.repository;

import com.example.veterinaryclinicsuperpets.entity.Veterinarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends CrudRepository<Veterinarian, Long> {
    Veterinarian findByUsername(String username);
    Veterinarian findByEmail(String email);
    Veterinarian findByPhoneNum(String phoneNum);
}
