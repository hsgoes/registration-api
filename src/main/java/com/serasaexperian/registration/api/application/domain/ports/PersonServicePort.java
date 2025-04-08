package com.serasaexperian.registration.api.application.domain.ports;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.infrastructure.request.PersonFilter;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.UpdatePersonRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonServicePort {
    Person createPerson(CreatePersonRequestDTO createPersonRequestDTO);
    Page<Person> getAll(PersonFilter personFilter, Pageable pageable);
    void deletePerson(String id);
    Person updatePerson(String id, UpdatePersonRequestDTO updatePersonRequestDTO);
}
