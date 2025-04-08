package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.application.domain.ports.PersonServicePort;
import com.serasaexperian.registration.api.infrastructure.request.PersonFilter;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.UpdatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.PersonResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController implements PersonAPI {

    private final PersonServicePort servicePort;

    public PersonController(PersonServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @Override
    public ResponseEntity<PersonResponseDTO> createPerson(
            CreatePersonRequestDTO createPersonRequestDTO
    ) {
        var person = servicePort.createPerson(createPersonRequestDTO);
        var personResponseDTO = new PersonResponseDTO(person);

        return ResponseEntity
                .ok()
                .body(personResponseDTO);
    }

    @Override
    public ResponseEntity<Page<PersonResponseDTO>> getPersons(PersonFilter personFilter, Pageable pageable) {
        var persons = servicePort.getAll(personFilter, pageable);

        Page<PersonResponseDTO> response = persons.map(PersonResponseDTO::new);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> deletePerson(String id) {

        servicePort.deletePerson(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @Override
    public ResponseEntity<PersonResponseDTO> updatePerson(
            String id,
            UpdatePersonRequestDTO updatePersonRequestDTO
    ) {
        var person = servicePort.updatePerson(id, updatePersonRequestDTO);

        var personResponseDTO = new PersonResponseDTO(person);

        return ResponseEntity
                .ok()
                .body(personResponseDTO);
    }
}
