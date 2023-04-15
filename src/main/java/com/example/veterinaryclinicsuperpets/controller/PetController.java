package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.pet.PetRequest;
import com.example.veterinaryclinicsuperpets.dto.pet.PetResponse;
import com.example.veterinaryclinicsuperpets.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {
  private final PetService petService;

  @GetMapping("/{id}")
  public PetResponse getPet(@PathVariable Long id) {
    return petService.getById(id);
  }

  @GetMapping()
  public List<PetResponse> getAllPets() {
    return petService.getAll();
  }

  @DeleteMapping("/{id}")
  public PetResponse deletePet(@PathVariable Long id) {
    return petService.delete(id);
  }

  @PostMapping()
  public Long postPet(@RequestBody PetRequest request) {
    return petService.create(request);
  }

  @PutMapping(value = "/{id}")
  public PetResponse updatePet(@RequestBody PetRequest request, @PathVariable Long id) {
    return petService.update(request, id);
  }
}
