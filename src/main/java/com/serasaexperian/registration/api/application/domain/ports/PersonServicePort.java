package com.serasaexperian.registration.api.application.domain.ports;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;

public interface PersonServicePort {
    Person createPerson(CreatePersonRequestDTO createPersonRequestDTO);
    Person getPerson(String id);
    void deletePerson(String id);
    Person updatePerson(String id, CreatePersonRequestDTO createPersonRequestDTO);
}
