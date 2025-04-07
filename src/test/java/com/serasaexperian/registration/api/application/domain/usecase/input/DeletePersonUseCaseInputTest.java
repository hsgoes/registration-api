package com.serasaexperian.registration.api.application.domain.usecase.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeletePersonUseCaseInputTest {

    @Test
    void shouldCreateInput_WhenIdIsValid() {
        var input = new DeletePersonUseCaseInput("123");

        assertEquals("123", input.id());
    }

    @Test
    void shouldThrowException_WhenIdIsNull() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new DeletePersonUseCaseInput(null));

        assertEquals("O id da pessoa não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void shouldThrowException_WhenIdIsEmpty() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new DeletePersonUseCaseInput(""));

        assertEquals("O id da pessoa não pode ser nulo ou vazio", exception.getMessage());
    }
}