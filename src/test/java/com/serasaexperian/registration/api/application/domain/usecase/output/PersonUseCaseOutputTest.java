package com.serasaexperian.registration.api.application.domain.usecase.output;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonUseCaseOutputTest {

    private static final String PERSON_ID = "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";

    @Test
    void shouldCreatePersonUseCaseOutputFromPerson() {
        var person = Person.from(
                Id.from(PERSON_ID),
                "João",
                "25",
                Address.from("12345678", "SP", "São Paulo", "Centro", "Rua A", "100"),
                Phone.from("11", "912345678"),
                800
        );

        var output = new PersonUseCaseOutput(person);

        assertEquals(PERSON_ID, output.personId());
        assertEquals("João", output.name());
        assertEquals("25", output.age());
        assertEquals("12345678", output.zipCode());
        assertEquals("SP", output.state());
        assertEquals("São Paulo", output.city());
        assertEquals("Centro", output.neighborhood());
        assertEquals("Rua A", output.street());
        assertEquals("100", output.streetNumber());
        assertEquals("11", output.ddd());
        assertEquals("912345678", output.phoneNumber());
        assertEquals(800, output.score());
    }

    @Test
    void shouldConvertPersonUseCaseOutputToPerson() {
        var output = new PersonUseCaseOutput(
                PERSON_ID,
                "João",
                "25",
                "12345678",
                "SP",
                "São Paulo",
                "Centro",
                "Rua A",
                "100",
                "11",
                "912345678",
                800
        );

        var person = output.toPerson();

        assertEquals(PERSON_ID, person.getId().value());
        assertEquals("João", person.getName().value());
        assertEquals("25", person.getAge().value());
        assertEquals("12345678", person.getAddress().getZipCode().value());
        assertEquals("SP", person.getAddress().getState().value());
        assertEquals("São Paulo", person.getAddress().getCity().value());
        assertEquals("Centro", person.getAddress().getNeighborhood().value());
        assertEquals("Rua A", person.getAddress().getStreet().value());
        assertEquals("100", person.getAddress().getNumber().value());
        assertEquals("11", person.getPhone().getDdd().value());
        assertEquals("912345678", person.getPhone().getNumber().value());
        assertEquals(800, person.getScore().value());
    }
}