package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.UnitTest;
import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.usecase.input.UpdatePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.output.PersonUseCaseOutput;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdatePersonUseCaseTest extends UnitTest {

    private static final String PERSON_ID = "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";

    @Test
    void shouldUpdatePersonCompletely_whenAllFieldsAreProvided() {
        var personId = Id.from(PERSON_ID);
        var existingPerson = Person.from(
                personId,
                "João",
                "25",
                Address.from("12345678", "SP", "São Paulo", "Centro", "Rua A", "100"),
                Phone.from("11", "912345678"),
                800
        );

        var input = new UpdatePersonUseCaseInput(
                PERSON_ID,
                "João Silva",
                "30",
                "87654321",
                "RJ",
                "Rio de Janeiro",
                "Copacabana",
                "Rua B",
                "200",
                "21",
                "999999999",
                900
        );

        when(repositoryPort.findById(personId)).thenReturn(Optional.of(existingPerson));
        when(repositoryPort.save(any(Person.class))).thenAnswer(invocation -> invocation.getArgument(0));

        PersonUseCaseOutput output = updatePersonUseCase.execute(input);

        assertNotNull(output);
        assertEquals("João Silva", output.name());
        assertEquals("30", output.age());
        assertEquals("87654321", output.zipCode());
        assertEquals("RJ", output.state());
        assertEquals("Rio de Janeiro", output.city());
        assertEquals("Copacabana", output.neighborhood());
        assertEquals("Rua B", output.street());
        assertEquals("200", output.streetNumber());
        assertEquals("21", output.ddd());
        assertEquals("999999999", output.phoneNumber());
        assertEquals(900, output.score());

        verify(repositoryPort).findById(personId);
        verify(repositoryPort).save(any(Person.class));
    }

    @Test
    void shouldUpdatePersonPartially_whenSomeFieldsAreProvided() {
        var personId = Id.from(PERSON_ID);
        var existingPerson = Person.from(
                personId,
                "João",
                "25",
                Address.from("12345678", "SP", "São Paulo", "Centro", "Rua A", "100"),
                Phone.from("11", "912345678"),
                800
        );

        var input = new UpdatePersonUseCaseInput(
                PERSON_ID,
                null,
                "30",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                900
        );

        when(repositoryPort.findById(personId)).thenReturn(Optional.of(existingPerson));
        when(repositoryPort.save(any(Person.class))).thenAnswer(invocation -> invocation.getArgument(0));

        PersonUseCaseOutput output = updatePersonUseCase.execute(input);

        assertNotNull(output);
        assertEquals("João", output.name());
        assertEquals("30", output.age());
        assertEquals("12345678", output.zipCode());
        assertEquals("SP", output.state());
        assertEquals("São Paulo", output.city());
        assertEquals("Centro", output.neighborhood());
        assertEquals("Rua A", output.street());
        assertEquals("100", output.streetNumber());
        assertEquals("11", output.ddd());
        assertEquals("912345678", output.phoneNumber());
        assertEquals(900, output.score());

        verify(repositoryPort).findById(personId);
        verify(repositoryPort).save(any(Person.class));
    }

    @Test
    void shouldThrowException_whenPersonDoesNotExist() {
        var personId = Id.from(PERSON_ID);
        var input = new UpdatePersonUseCaseInput(
                PERSON_ID,
                "João Silva",
                "30",
                "87654321",
                "RJ",
                "Rio de Janeiro",
                "Copacabana",
                "Rua B",
                "200",
                "21",
                "999999999",
                900
        );

        when(repositoryPort.findById(personId)).thenReturn(Optional.empty());

        var exception = assertThrows(RuntimeException.class, () -> updatePersonUseCase.execute(input));
        assertEquals("Pessoa com o id " + PERSON_ID + " não encontrada.", exception.getMessage());

        verify(repositoryPort).findById(personId);
        verify(repositoryPort, never()).save(any(Person.class));
    }
}