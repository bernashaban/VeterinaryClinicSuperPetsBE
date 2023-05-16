package com.example.veterinaryclinicsuperpets.repository;

import com.example.veterinaryclinicsuperpets.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByUsername(String username);
}
