package com.serasaexperian.registration.api.infrastructure.adapters.entity;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressEntityTest {
    private Address address;
    private PersonEntity personEntity;

    @BeforeEach
    public void setUp() {
        address = Address.from(
                "12345678",
                "São Paulo",
                "São Paulo",
                "Centro",
                "Rua A",
                "123"
        );
        personEntity = new PersonEntity();
    }

    @Test
    public void shouldCreateAddressEntity_whenConstructorIsCalled() {
        AddressEntity addressEntity = new AddressEntity(address, personEntity);

        assertEquals("12345678", addressEntity.getZipCode());
        assertEquals("São Paulo", addressEntity.getState());
        assertEquals("São Paulo", addressEntity.getCity());
        assertEquals("Centro", addressEntity.getNeighborhood());
        assertEquals("Rua A", addressEntity.getStreet());
        assertEquals("123", addressEntity.getNumber());
    }

    @Test
    public void shouldConvertToDomain_whenToDomainIsCalled() {
        AddressEntity addressEntity = new AddressEntity(address, personEntity);
        Address domainAddress = addressEntity.toDomain();

        assertEquals("12345678", domainAddress.getZipCode().value());
        assertEquals("São Paulo", domainAddress.getState().value());
        assertEquals("São Paulo", domainAddress.getCity().value());
        assertEquals("Centro", domainAddress.getNeighborhood().value());
        assertEquals("Rua A", domainAddress.getStreet().value());
        assertEquals("123", domainAddress.getNumber().value());
    }
}