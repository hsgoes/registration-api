package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.UnitTest;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.usecase.input.CreatePersonUseCaseInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CreatePersonUseCaseTest extends UnitTest {

    private CreatePersonUseCaseInput input;

    @BeforeEach
    void setUp() {
        input =
            new CreatePersonUseCaseInput(
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
    }

    @Test
    void shouldCreatePerson_WhenInputIsValid() {
        when(repositoryPort.save(any(Person.class))).thenAnswer(invocation -> invocation.getArgument(0));

        var output = createPersonUseCase.execute(input);

        assertNotNull(output.personId());
        assertEquals(input.name(), output.name());
        assertEquals(input.age(), output.age());
        assertEquals(input.zipCode(), output.zipCode());
        assertEquals(input.state(), output.state());
        assertEquals(input.city(), output.city());
        assertEquals(input.neighborhood(), output.neighborhood());
        assertEquals(input.street(), output.street());
        assertEquals(input.streetNumber(), output.streetNumber());
        assertEquals(input.ddd(), output.ddd());
        assertEquals(input.phoneNumber(), output.phoneNumber());
        assertEquals(input.score(), output.score());

        verify(repositoryPort, times(1)).save(any(Person.class));
    }
}