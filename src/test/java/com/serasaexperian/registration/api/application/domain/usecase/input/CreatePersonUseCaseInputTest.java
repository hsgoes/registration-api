package com.serasaexperian.registration.api.application.domain.usecase.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreatePersonUseCaseInputTest {

    @Test
    void shouldCreateInput_WhenAllFieldsAreValid() {
        var input = new CreatePersonUseCaseInput(
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
    void shouldThrowException_WhenNameIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            null,
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

        assertEquals("O Nome não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenAgeIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            null,
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

        assertEquals("A Idade não pode ser nula ou vazia", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenZipCodeIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            "30",
            null,
            "São Paulo",
            "São Paulo",
            "Centro",
            "Rua A",
            "123",
            "11",
            "912345678",
            900
        ));

        assertEquals("O CEP não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenStateIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            "30",
            "12345678",
            null,
            "São Paulo",
            "Centro",
            "Rua A",
            "123",
            "11",
            "912345678",
            900
        ));

        assertEquals("O Estado não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenCityIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            "30",
            "12345678",
            "São Paulo",
            null,
            "Centro",
            "Rua A",
            "123",
            "11",
            "912345678",
            900
        ));

        assertEquals("A Cidade não pode ser nula ou vazia", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenNeighborhoodIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            "30",
            "12345678",
            "São Paulo",
            "São Paulo",
            null,
            "Rua A",
            "123",
            "11",
            "912345678",
            900
        ));

        assertEquals("O Bairro não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenStreetIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            "30",
            "12345678",
            "São Paulo",
            "São Paulo",
            "Centro",
            null,
            "123",
            "11",
            "912345678",
            900
        ));

        assertEquals("A Rua não pode ser nula ou vazia", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenStreetNumberIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            "30",
            "12345678",
            "São Paulo",
            "São Paulo",
            "Centro",
            "Rua A",
            null,
            "11",
            "912345678",
            900
        ));

        assertEquals("O Número não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenDddIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            "30",
            "12345678",
            "São Paulo",
            "São Paulo",
            "Centro",
            "Rua A",
            "123",
            null,
            "912345678",
            900
        ));

        assertEquals("O DDD não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenPhoneNumberIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
            "Joao Silva",
            "30",
            "12345678",
            "São Paulo",
            "São Paulo",
            "Centro",
            "Rua A",
            "123",
            "11",
            null,
            900
        ));

        assertEquals("O Telefone não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenScoreIsNull() {
        var exception =
            assertThrows(IllegalArgumentException.class, () -> new CreatePersonUseCaseInput(
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
            null
        ));

        assertEquals("O Score não pode ser nulo ou vazio", exception.getMessage());
    }
}