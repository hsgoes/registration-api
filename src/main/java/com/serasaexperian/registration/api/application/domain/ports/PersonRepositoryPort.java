package com.serasaexperian.registration.api.application.domain.ports;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;

public interface PersonRepositoryPort {
    Person createPerson(Person person);

    Person getPerson(Id id);

    void deletePerson(Id id);

    Person updatePerson(Id id, String name, String email, String phoneNumber, String address);
}
