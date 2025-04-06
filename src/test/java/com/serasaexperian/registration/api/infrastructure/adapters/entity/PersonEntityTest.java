package com.serasaexperian.registration.api.infrastructure.adapters.entity;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonEntityTest {
    private Person person;

    private static final String PERSON_ID =  "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";
    private static final String ADDRESS_ID = "5ce5b33b-2e64-40f9-acb4-6aa1edc953c1";

    @BeforeEach
    void setUp() {
        person = Person.from(
                Id.from(PERSON_ID),
                "Joao Silva",
                "30",
                Address.from(
                        Id.from(ADDRESS_ID),
                        "12345678",
                        "São Paulo",
                        "São Paulo",
                        "Centro"
                ),
                Phone.from(
                        "11",
                        "912345678"
                ),
                900
        );
    }

    @Test
    void shouldCreatePersonEntity_whenConstructorIsCalled() {
        PersonEntity personEntity = new PersonEntity(person);

        assertEquals(PERSON_ID, personEntity.getId());
        assertEquals("Joao Silva", personEntity.getName());
        assertEquals("30", personEntity.getAge());
        assertEquals(ADDRESS_ID, personEntity.getAddress().getId());
        assertEquals("12345678", personEntity.getAddress().getZipCode());
        assertEquals("São Paulo", personEntity.getAddress().getState());
        assertEquals("São Paulo", personEntity.getAddress().getCity());
        assertEquals("Centro", personEntity.getAddress().getNeighborhood());
        assertEquals("11", personEntity.getPhone().getDDD());
        assertEquals("912345678", personEntity.getPhone().getNumber());
    }

    @Test
    void shouldConvertToDomain_whenToDomainIsCalled() {
        PersonEntity personEntity = new PersonEntity(person);
        Person domainPerson = personEntity.toDomain();

        assertEquals(PERSON_ID, domainPerson.getId().value());
        assertEquals("Joao Silva", domainPerson.getName().value());
        assertEquals("30", domainPerson.getAge().value());
        assertEquals(ADDRESS_ID, domainPerson.getAddress().getId().value());
        assertEquals("12345678", domainPerson.getAddress().getZipCode().value());
        assertEquals("São Paulo", domainPerson.getAddress().getState().value());
        assertEquals("São Paulo", domainPerson.getAddress().getCity().value());
        assertEquals("Centro", domainPerson.getAddress().getNeighborhood().value());
        assertEquals("11", domainPerson.getPhone().getDdd().value());
        assertEquals("912345678", domainPerson.getPhone().getNumber().value());
        assertEquals(900, domainPerson.getScore().value());
    }
}