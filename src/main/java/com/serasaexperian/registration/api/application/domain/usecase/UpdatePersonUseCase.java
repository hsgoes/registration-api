package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.input.UpdatePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.output.PersonUseCaseOutput;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;

public class UpdatePersonUseCase {

    private final PersonRepositoryPort repositoryPort;

    public UpdatePersonUseCase(PersonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public PersonUseCaseOutput execute(UpdatePersonUseCaseInput input) {
        var person = repositoryPort.findById(Id.from(input.personId()))
                .orElseThrow(() -> new RuntimeException("Pessoa com o id " + input.personId() + " não encontrada."));

        var savedPerson = repositoryPort.save(person);

        return new PersonUseCaseOutput(savedPerson);
    }
}
