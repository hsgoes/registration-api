package com.serasaexperian.registration.api.application.domain.ports;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.UpdatePersonRequestDTO;

public interface PersonServicePort {
    Person createPerson(CreatePersonRequestDTO createPersonRequestDTO);
    Person getPerson(String id);
    void deletePerson(String id);
    Person updatePerson(String id, UpdatePersonRequestDTO updatePersonRequestDTO);
}
