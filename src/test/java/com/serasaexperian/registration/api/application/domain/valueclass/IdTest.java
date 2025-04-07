package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IdTest {

    @Test
    void shouldCreateId_WhenValueIsValidUUID() {
        String validUUID = UUID.randomUUID().toString();
        var id = new Id(validUUID);

        assertEquals(validUUID, id.value());
    }

    @Test
    void shouldThrowException_WhenValueIsInvalidUUID() {
        String invalidUUID = "invalid-uuid";

        var exception = assertThrows(IllegalArgumentException.class, () -> new Id(invalidUUID));
        assertEquals("O valor " + invalidUUID + " não é um UUID válido.", exception.getMessage());
    }

    @Test
    void shouldCreateIdUsingFromMethod_WhenValueIsValidUUID() {
        String validUUID = UUID.randomUUID().toString();
        var id = Id.from(validUUID);

        assertEquals(validUUID, id.value());
    }

    @Test
    void shouldThrowExceptionUsingFromMethod_WhenValueIsInvalidUUID() {
        String invalidUUID = "invalid-uuid";

        var exception = assertThrows(IllegalArgumentException.class, () -> Id.from(invalidUUID));
        assertEquals("O valor " + invalidUUID + " não é um UUID válido.", exception.getMessage());
    }

    @Test
    void shouldCreateIdUsingCreateMethod() {
        var id = Id.create();
        UUID.fromString(id.value()); // Verifica se o valor gerado é um UUID válido
    }
}