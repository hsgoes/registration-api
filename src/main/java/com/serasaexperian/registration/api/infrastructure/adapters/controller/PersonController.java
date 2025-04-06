package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.application.domain.ports.PersonServicePort;
import com.serasaexperian.registration.api.infrastructure.adapters.PersonAPI;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.PersonResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class PersonController implements PersonAPI {

    @Autowired
    private final PersonServicePort servicePort;

    public PersonController(PersonServicePort personServicePort) {
        this.servicePort = personServicePort;
    }

    @Override
    public ResponseEntity<PersonResponseDTO> createPerson(
            CreatePersonRequestDTO createPersonRequestDTO
    ) {

        var response = servicePort.createPerson(createPersonRequestDTO);
        var personResponseDTO = new PersonResponseDTO(response);

        return ResponseEntity.ok(personResponseDTO);
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
