package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
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

        var updatedPerson = updateWith(person, input);

        var savedPerson = repositoryPort.save(updatedPerson);

        return new PersonUseCaseOutput(savedPerson);
    }

    private Person updateWith(Person person, UpdatePersonUseCaseInput input) {
        return Person.from(
                person.getId(),
                input.name() != null ? input.name() : person.getName().value(),
                input.age() != null ? input.age() : person.getAge().value(),
                Address.from(
                        input.zipCode() != null ? input.zipCode() : person.getAddress().getZipCode().value(),
                        input.state() != null ? input.state() : person.getAddress().getState().toString(),
                        input.city() != null ? input.city() : person.getAddress().getCity().value(),
                        input.neighborhood() != null ? input.neighborhood() : person.getAddress().getNeighborhood().value(),
                        input.street() != null ? input.street() : person.getAddress().getStreet().value(),
                        input.streetNumber() != null ? input.streetNumber() : person.getAddress().getNumber().value()
                ),
                Phone.from(
                        input.ddd() != null ? input.ddd() : person.getPhone().getDdd().value(),
                        input.phoneNumber() != null ? input.phoneNumber() : person.getPhone().getNumber().value()
                ),
                input.score() != null ? input.score() : person.getScore().value()
        );
    }
}
