package com.example.veterinaryclinicsuperpets.repository;

import com.example.veterinaryclinicsuperpets.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByUsername(String username);
}
