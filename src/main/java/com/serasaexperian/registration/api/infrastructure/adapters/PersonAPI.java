package com.serasaexperian.registration.api.infrastructure.adapters;

import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.UpdatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.PersonResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/person")
public interface PersonAPI {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PersonResponseDTO> createPerson(@RequestBody CreatePersonRequestDTO createPersonRequestDTO);

    @GetMapping("/{id}")
    ResponseEntity<PersonResponseDTO> getPerson(@PathVariable String id, @RequestParam String page, @RequestParam String size);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deletePerson(@PathVariable String id);

    @PutMapping("/{id}")
    ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable String id, @RequestBody UpdatePersonRequestDTO updatePersonRequestDTO);
}
