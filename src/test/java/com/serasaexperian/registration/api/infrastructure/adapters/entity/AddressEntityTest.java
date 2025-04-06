package com.serasaexperian.registration.api.infrastructure.adapters.entity;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressEntityTest {
    private Address address;

    private static final String ADDRESS_ID = "5ce5b33b-2e64-40f9-acb4-6aa1edc953c1";

    @BeforeEach
    public void setUp() {
        address = Address.from(
                Id.from(ADDRESS_ID),
                "12345678",
                "São Paulo",
                "São Paulo",
                "Centro"
        );
    }

    @Test
    public void shouldCreateAddressEntity_whenConstructorIsCalled() {
        AddressEntity addressEntity = new AddressEntity(address);

        assertEquals(ADDRESS_ID, addressEntity.getId());
        assertEquals("12345678", addressEntity.getZipCode());
        assertEquals("São Paulo", addressEntity.getState());
        assertEquals("São Paulo", addressEntity.getCity());
        assertEquals("Centro", addressEntity.getNeighborhood());
    }

    @Test
    public void shouldConvertToDomain_whenToDomainIsCalled() {
        AddressEntity addressEntity = new AddressEntity(address);
        Address domainAddress = addressEntity.toDomain();

        assertEquals(ADDRESS_ID, domainAddress.getId().value());
        assertEquals("12345678", domainAddress.getZipCode().value());
        assertEquals("São Paulo", domainAddress.getState().value());
        assertEquals("São Paulo", domainAddress.getCity().value());
        assertEquals("Centro", domainAddress.getNeighborhood().value());
    }
}
