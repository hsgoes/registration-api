package com.bradesco.registration.api.infrastructure.controller;

import com.bradesco.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.bradesco.registration.api.infrastructure.response.PersonResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/api/v1/person")
public interface PersonAPI {

    @PostMapping
    ResponseEntity<PersonResponseDTO> createPerson(@RequestBody CreatePersonRequestDTO createPersonRequestDTO);

    @GetMapping("/{id}")
    ResponseEntity<PersonResponseDTO> getPerson(@PathVariable String id, @RequestParam String page, @RequestParam String size);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deletePerson();

    @PutMapping("/{id}")
    ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable String id, @RequestBody CreatePersonRequestDTO createPersonRequestDTO);
}
