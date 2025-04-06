package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.input.FindPersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.output.PersonUseCaseOutput;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;

public class FindPersonUseCase {

    private final PersonRepositoryPort repositoryPort;

    public FindPersonUseCase(PersonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public PersonUseCaseOutput execute(FindPersonUseCaseInput input) {
        var person = repositoryPort.findById(Id.from(input.id()))
                .orElseThrow(() -> new RuntimeException("Pessoa com o id " + input.id() + " não encontrada."));

        return new PersonUseCaseOutput(person);
    }
}
