package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.input.DeletePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;

public class DeletePersonUseCase {

    private final PersonRepositoryPort repositoryPort;

    public DeletePersonUseCase(PersonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public void execute(DeletePersonUseCaseInput input) {
        var person = repositoryPort.findById(Id.from(input.id()))
                .orElseThrow(() -> new RuntimeException("Pessoa com o id " + input.id() + " não encontrada."));
    }
}
