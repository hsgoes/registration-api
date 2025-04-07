package com.serasaexperian.registration.api.application.domain.usecase.input;

public record FindPersonUseCaseInput(String id) implements UseCaseInput {
    public FindPersonUseCaseInput(String id) {
        this.id = requireNonNull(id, "O id da pessoa não pode ser nulo ou vazio");
    }
}
