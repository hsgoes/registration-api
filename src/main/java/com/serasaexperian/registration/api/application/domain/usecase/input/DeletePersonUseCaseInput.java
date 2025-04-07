package com.serasaexperian.registration.api.application.domain.usecase.input;

public record DeletePersonUseCaseInput(String id) implements UseCaseInput {
    public DeletePersonUseCaseInput(String id) {
        this.id = requireNonNull(id, "O id da pessoa não pode ser nulo ou vazio");
    }
}
