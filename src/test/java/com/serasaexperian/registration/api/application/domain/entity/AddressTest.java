package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddressTest {

    @Test
    public void shouldCreateAddress_whenCreateIsCalled() {
        Address address = Address.create(
                new ZipCode("12345678"),
                new State("São Paulo"),
                new City("São Paulo"),
                new Neighborhood("Centro"),
                new Street("Rua A"),
                new StreetNumber("123")
        );

        assertNotNull(address.getId());
        assertEquals("12345678", address.getZipCode().value());
        assertEquals("São Paulo", address.getState().value());
        assertEquals("São Paulo", address.getCity().value());
        assertEquals("Centro", address.getNeighborhood().value());
        assertEquals("Rua A", address.getStreet().value());
        assertEquals("123", address.getNumber().value());
    }

    @Test
    public void shouldCreateAddress_whenFromIsCalled() {
        Id id = Id.from("5ce5b33b-2e64-40f9-acb4-6aa1edc953c1");
        Address address = Address.from(
                id,
                "12345678",
                "São Paulo",
                "São Paulo",
                "Centro",
                "Rua A",
                "123"
        );

        assertEquals(id, address.getId());
        assertEquals("12345678", address.getZipCode().value());
        assertEquals("São Paulo", address.getState().value());
        assertEquals("São Paulo", address.getCity().value());
        assertEquals("Centro", address.getNeighborhood().value());
        assertEquals("Rua A", address.getStreet().value());
        assertEquals("123", address.getNumber().value());
    }
}