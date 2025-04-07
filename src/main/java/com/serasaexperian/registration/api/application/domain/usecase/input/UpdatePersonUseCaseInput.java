package com.serasaexperian.registration.api.application.domain.usecase.input;

public record UpdatePersonUseCaseInput(
        String personId,
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

    public UpdatePersonUseCaseInput(
            String personId,
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
        this.personId = requireNonNull(personId, "O ID da pessoa não pode ser nulo ou vazio");
        this.name = name;
        this.age = age;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.streetNumber = streetNumber;
        this.ddd = ddd;
        this.phoneNumber = phoneNumber;
        this.score = score;
    }
}