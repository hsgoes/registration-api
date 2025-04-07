package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.input.CreatePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.output.PersonUseCaseOutput;
import com.serasaexperian.registration.api.application.domain.valueclass.*;

public class CreatePersonUseCase {

    private final PersonRepositoryPort repositoryPort;

    public CreatePersonUseCase(PersonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public PersonUseCaseOutput execute(CreatePersonUseCaseInput input) {
        var person = toPerson(input);

        var savedPerson = repositoryPort.save(person);

        return new PersonUseCaseOutput(savedPerson);
    }

    private Person toPerson(CreatePersonUseCaseInput input) {
        return Person.create(
                new Name(input.name()),
                new Age(input.age()),
                Address.create(
                        new ZipCode(input.zipCode()),
                        new State(input.state()),
                        new City(input.city()),
                        new Neighborhood(input.neighborhood()),
                        new Street(input.street()),
                        new StreetNumber(input.streetNumber())
                ),
                Phone.create(
                        new DDD(input.ddd()),
                        new PhoneNumber(input.phoneNumber())
                ),
                new Score(input.score())
        );
    }
}
