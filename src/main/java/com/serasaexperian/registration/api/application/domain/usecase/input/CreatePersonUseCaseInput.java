package com.serasaexperian.registration.api.application.domain.usecase.input;

public record CreatePersonUseCaseInput(
        String name,
        String age,
        String zipCode,
        String state,
        String city,
        String neighborhood,
        String street,
        String streetNumber,
        String ddd,
        String phoneNumber,
        Integer score
) implements UseCaseInput {

    public CreatePersonUseCaseInput(
            String name,
            String age,
            String zipCode,
            String state,
            String city,
            String neighborhood,
            String street,
            String streetNumber,
            String ddd,
            String phoneNumber,
            Integer score
    ) {
        this.name = requireNonNull(name, "O Nome não pode ser nulo ou vazio");
        this.age = requireNonNull(age, "A Idade não pode ser nula ou vazia");
        this.zipCode = requireNonNull(zipCode, "O CEP não pode ser nulo ou vazio");
        this.state = requireNonNull(state, "O Estado não pode ser nulo ou vazio");
        this.city = requireNonNull(city, "A Cidade não pode ser nula ou vazia");
        this.neighborhood = requireNonNull(neighborhood, "O Bairro não pode ser nulo ou vazio");
        this.street = requireNonNull(street, "A Rua não pode ser nula ou vazia");
        this.streetNumber = requireNonNull(streetNumber, "O Número não pode ser nulo ou vazio");
        this.ddd = requireNonNull(ddd, "O DDD não pode ser nulo ou vazio");
        this.phoneNumber = requireNonNull(phoneNumber, "O Telefone não pode ser nulo ou vazio");
        this.score = requireNonNull(score, "O Score não pode ser nulo ou vazio");
    }
}