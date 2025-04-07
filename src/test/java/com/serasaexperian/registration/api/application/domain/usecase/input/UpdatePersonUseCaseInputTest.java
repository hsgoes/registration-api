package com.serasaexperian.registration.api.application.domain.usecase.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdatePersonUseCaseInputTest {

    @Test
    void shouldCreateInput_WhenAllFieldsAreProvided() {
        var input = new UpdatePersonUseCaseInput(
                "123",
                "Joao Silva",
                "30",
                "12345678",
                "São Paulo",
                "São Paulo",
                "Centro",
                "Rua A",
                "123",
                "11",
                "912345678",
                900
        );

        assertEquals("123", input.personId());
        assertEquals("Joao Silva", input.name());
        assertEquals("30", input.age());
        assertEquals("12345678", input.zipCode());
        assertEquals("São Paulo", input.state());
        assertEquals("São Paulo", input.city());
        assertEquals("Centro", input.neighborhood());
        assertEquals("Rua A", input.street());
        assertEquals("123", input.streetNumber());
        assertEquals("11", input.ddd());
        assertEquals("912345678", input.phoneNumber());
        assertEquals(900, input.score());
    }

    @Test
    void shouldCreateInput_WhenOnlyPersonIdIsProvided() {
        var input = new UpdatePersonUseCaseInput(
                "123",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        assertEquals("123", input.personId());
        assertNull(input.name());
        assertNull(input.age());
        assertNull(input.zipCode());
        assertNull(input.state());
        assertNull(input.city());
        assertNull(input.neighborhood());
        assertNull(input.street());
        assertNull(input.streetNumber());
        assertNull(input.ddd());
        assertNull(input.phoneNumber());
        assertNull(input.score());
    }

    @Test
    void shouldThrowException_WhenPersonIdIsNull() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new UpdatePersonUseCaseInput(
                null,
                "Joao Silva",
                "30",
                "12345678",
                "São Paulo",
                "São Paulo",
                "Centro",
                "Rua A",
                "123",
                "11",
                "912345678",
                900
        ));

        assertEquals("O ID da pessoa não pode ser nulo ou vazio", exception.getMessage());
    }
}