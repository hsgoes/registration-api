package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.UnitTest;
import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.usecase.input.DeletePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DeletePersonUseCaseTest extends UnitTest {

    private static final String PERSON_ID = "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";

    private DeletePersonUseCaseInput input;
    private Person person;

    @BeforeEach
    void setUp() {
        person =
            Person.from(
                Id.from(PERSON_ID),
                "Joao Silva",
                "30",
                Address.from(
                        "12345678",
                        "São Paulo",
                        "São Paulo",
                        "Centro",
                        "Rua A",
                        "123"
                ),
                Phone.from(
                        "11",
                        "912345678"
                ),
            900
            );

        input = new DeletePersonUseCaseInput(PERSON_ID);
    }

    @Test
    void shouldDeletePerson_WhenPersonExists() {
        when(repositoryPort.findById(Id.from(input.id()))).thenReturn(Optional.of(person));

        deletePersonUseCase.execute(new DeletePersonUseCaseInput(input.id()));

        verify(repositoryPort, times(1)).delete(Id.from(person.getId().value()));
    }

    @Test
    void shouldThrowExceptionWhen_PersonDoesNotExist() {
        when(repositoryPort.findById(Id.from(input.id()))).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> deletePersonUseCase.execute(new DeletePersonUseCaseInput(input.id())));
    }
}
