package com.example.veterinaryclinicsuperpets.repository;

import com.example.veterinaryclinicsuperpets.entity.Admin;
import com.example.veterinaryclinicsuperpets.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}
