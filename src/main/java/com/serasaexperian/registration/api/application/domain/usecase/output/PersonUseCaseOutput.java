package com.serasaexperian.registration.api.application.domain.usecase.output;

import com.serasaexperian.registration.api.application.domain.entity.Person;

public record PersonUseCaseOutput(
        String id,
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
    public PersonUseCaseOutput(Person person) {
        this(
                person.getId().value(),
                person.getName().value(),
                person.getAge().value(),
                person.getAddress().getZipCode().value(),
                person.getAddress().getState().value(),
                person.getAddress().getCity().value(),
                person.getAddress().getNeighborhood().value(),
                person.getAddress().getStreet().value(),
                person.getAddress().getNumber().value(),
                person.getPhone().getDdd().value(),
                person.getPhone().getNumber().value(),
                person.getScore().value()
        );
    }
}