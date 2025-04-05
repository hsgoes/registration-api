package com.bradesco.registration.api.infrastructure.controller;

import com.bradesco.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.bradesco.registration.api.infrastructure.response.PersonResponseDTO;
import org.springframework.http.ResponseEntity;

public class PersonController implements PersonAPI {
    @Override
    public ResponseEntity<PersonResponseDTO> createPerson(
            CreatePersonRequestDTO createPersonRequestDTO
    ) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<PersonResponseDTO> getPerson(
            String id,
            String page,
            String size
    ) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deletePerson() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<PersonResponseDTO> updatePerson(
            String id,
            CreatePersonRequestDTO createPersonRequestDTO
    ) {
        return ResponseEntity.ok().build();
    }
}
