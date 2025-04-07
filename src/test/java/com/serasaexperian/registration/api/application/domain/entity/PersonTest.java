package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.Age;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import com.serasaexperian.registration.api.application.domain.valueclass.Name;
import com.serasaexperian.registration.api.application.domain.valueclass.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonTest {

    private static final String PERSON_ID = "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";
    private static final String ADDRESS_ID = "5ce5b33b-2e64-40f9-acb4-6aa1edc953c1";

    @Test
    public void shouldCreatePerson_whenFromIsCalled() {
        Person person =
            Person.from(
                Id.from(PERSON_ID),
                "Joao Silva",
                "30",
                Address.from(
                        Id.from(ADDRESS_ID),
                        "12345678",
                        "São Paulo",
                        "São Paulo",
                        "Centro",
                        "Rua A",
                        "123"
                ),
                Phone.from(
                        "11",
                        "912345678"
                ),
                900
            );

        assertEquals(PERSON_ID, person.getId().value());
        assertEquals("Joao Silva", person.getName().value());
        assertEquals("30", person.getAge().value());
        assertEquals(ADDRESS_ID, person.getAddress().getId().value());
        assertEquals("12345678", person.getAddress().getZipCode().value());
        assertEquals("São Paulo", person.getAddress().getState().value());
        assertEquals("São Paulo", person.getAddress().getCity().value());
        assertEquals("Centro", person.getAddress().getNeighborhood().value());
        assertEquals("Rua A", person.getAddress().getStreet().value());
        assertEquals("123", person.getAddress().getNumber().value());
        assertEquals("11", person.getPhone().getDdd().value());
        assertEquals("912345678", person.getPhone().getNumber().value());
    }

    @Test
    public void shouldCreatePerson_whenCreateIsCalled() {
        Person person =
            Person.create(
                new Name("Joao Silva"),
                new Age("30"),
                Address.from(
                        Id.from(ADDRESS_ID),
                        "12345678",
                        "São Paulo",
                        "São Paulo",
                        "Centro",
                        "Rua A",
                        "123"
                ),
                Phone.from(
                        "11",
                        "912345678"
                ),
                new Score(900)
            );

        assertNotNull(person.getId().value());
        assertEquals("Joao Silva", person.getName().value());
        assertEquals("30", person.getAge().value());
        assertEquals(ADDRESS_ID, person.getAddress().getId().value());
        assertEquals("12345678", person.getAddress().getZipCode().value());
        assertEquals("São Paulo", person.getAddress().getState().value());
        assertEquals("São Paulo", person.getAddress().getCity().value());
        assertEquals("Centro", person.getAddress().getNeighborhood().value());
        assertEquals("Rua A", person.getAddress().getStreet().value());
        assertEquals("123", person.getAddress().getNumber().value());
        assertEquals("11", person.getPhone().getDdd().value());
        assertEquals("912345678", person.getPhone().getNumber().value());
    }
}