package com.serasaexperian.registration.api.infrastructure.adapters.service;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.ports.PersonServicePort;
import com.serasaexperian.registration.api.application.domain.usecase.CreatePersonUseCase;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceAdapter implements PersonServicePort {

    @Autowired
    private final CreatePersonUseCase createPersonUseCase;

    public PersonServiceAdapter(CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
    }

    @Override
    public Person createPerson(CreatePersonRequestDTO createPersonRequestDTO) {
        return null;
    }

    @Override
    public Person getPerson(String id) {
        return null;
    }

    @Override
    public void deletePerson(String id) {

    }

    @Override
    public Person updatePerson(String id, CreatePersonRequestDTO createPersonRequestDTO) {
        return null;
    }
}
