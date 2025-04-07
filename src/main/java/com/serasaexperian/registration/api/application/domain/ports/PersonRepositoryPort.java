package com.serasaexperian.registration.api.application.domain.ports;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;

import java.util.Optional;

public interface PersonRepositoryPort {
    Person save(Person person);

    Optional<Person> findById(Id id);

    void delete(Id id);
}
