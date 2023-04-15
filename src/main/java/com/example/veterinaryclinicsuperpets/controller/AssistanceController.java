package com.example.veterinaryclinicsuperpets.controller;

import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceRequest;
import com.example.veterinaryclinicsuperpets.dto.assistence.AssistanceResponse;
import com.example.veterinaryclinicsuperpets.service.AssistanceService;
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
@RequestMapping("/assistance")
@RequiredArgsConstructor
public class AssistanceController {
  private final AssistanceService assistanceService;

  @GetMapping("/{id}")
  public AssistanceResponse getAssistance(@PathVariable Long id) {
    return assistanceService.getById(id);
  }

  @GetMapping()
  public List<AssistanceResponse> getAllAssistance() {
    return assistanceService.getAll();
  }

  @DeleteMapping("/{id}")
  public AssistanceResponse deleteAssistance(@PathVariable Long id) {
    return assistanceService.delete(id);
  }

  @PostMapping()
  public Long postAssistance(@RequestBody AssistanceRequest request) {
    return assistanceService.create(request);
  }

  @PutMapping(value = "/{id}")
  public AssistanceResponse updateAssistance(
      @RequestBody AssistanceRequest request, @PathVariable Long id) {
    return assistanceService.update(request, id);
  }
}
