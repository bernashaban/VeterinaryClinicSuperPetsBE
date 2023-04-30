package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.owner.OwnerRequest;
import com.example.veterinaryclinicsuperpets.dto.owner.OwnerResponse;
import com.example.veterinaryclinicsuperpets.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/owner")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class OwnerController {
  private final OwnerService ownerService;

  @GetMapping("/{id}")
  public OwnerResponse getOwner(@PathVariable Long id) {
    return ownerService.getById(id);
  }

  @GetMapping()
  public List<OwnerResponse> getAllOwners() {
    return ownerService.getAll();
  }

  @DeleteMapping("/{id}")
  public OwnerResponse deleteOwner(@PathVariable Long id) {
    return ownerService.delete(id);
  }

  @PostMapping()
  public Long postOwner(@RequestBody OwnerRequest request) {
    return ownerService.create(request);
  }

  @PutMapping(value = "/{id}")
  public OwnerResponse updateOwner(@RequestBody OwnerRequest request, @PathVariable Long id) {
    return ownerService.update(request, id);
  }
}
