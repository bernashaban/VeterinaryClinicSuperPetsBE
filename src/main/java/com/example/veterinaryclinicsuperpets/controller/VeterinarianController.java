package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianRequest;
import com.example.veterinaryclinicsuperpets.dto.veterinarian.VeterinarianResponse;
import com.example.veterinaryclinicsuperpets.service.VeterinarianService;
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
@RequestMapping("/veterinarian")
@RequiredArgsConstructor
public class VeterinarianController {
  private final VeterinarianService vetService;

  @GetMapping("/{id}")
  public VeterinarianResponse getVeterinarian(@PathVariable Long id) {
    return vetService.getById(id);
  }

  @GetMapping()
  public List<VeterinarianResponse> getAllVeterinarians() {
    return vetService.getAll();
  }

  @DeleteMapping("/{id}")
  public VeterinarianResponse deleteVeterinarian(@PathVariable Long id) {
    return vetService.delete(id);
  }

  @PostMapping()
  public Long postVeterinarian(@RequestBody VeterinarianRequest request) {
    return vetService.create(request);
  }

  @PutMapping(value = "/{id}")
  public VeterinarianResponse updateVeterinarian(
      @RequestBody VeterinarianRequest request, @PathVariable Long id) {
    return vetService.update(request, id);
  }
}
