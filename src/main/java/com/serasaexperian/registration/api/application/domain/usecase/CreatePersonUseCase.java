package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.input.CreatePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.output.PersonUseCaseOutput;

public class CreatePersonUseCase {

    private final PersonRepositoryPort repositoryPort;

    public CreatePersonUseCase(PersonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public PersonUseCaseOutput execute(CreatePersonUseCaseInput input) {
        var person = input.toPerson();

        var savedPerson = repositoryPort.save(person);

        return new PersonUseCaseOutput(savedPerson);
    }
}
