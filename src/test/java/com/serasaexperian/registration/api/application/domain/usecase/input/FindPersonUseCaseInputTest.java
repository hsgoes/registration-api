package com.serasaexperian.registration.api.application.domain.usecase.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindPersonUseCaseInputTest {

    @Test
    void shouldCreateInput_WhenIdIsValid() {
        var input = new FindPersonUseCaseInput("123");

        assertEquals("123", input.id());
    }

    @Test
    void shouldThrowException_WhenIdIsNull() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new FindPersonUseCaseInput(null));

        assertEquals("O id da pessoa não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenIdIsEmpty() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new FindPersonUseCaseInput(""));

        assertEquals("O id da pessoa não pode ser nulo ou vazio", exception.getMessage());
    }
}