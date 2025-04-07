package com.serasaexperian.registration.api.application.domain.usecase;

import com.serasaexperian.registration.api.UnitTest;
import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.usecase.input.FindPersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.output.PersonUseCaseOutput;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FindPersonUseCaseTest extends UnitTest {

    private static final String PERSON_ID = "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";

    private FindPersonUseCaseInput input;
    private Person person;

    @BeforeEach
    void setUp() {
        input = new FindPersonUseCaseInput(PERSON_ID);
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
    }

    @Test
    void shouldReturnPerson_WhenPersonExists() {
        when(repositoryPort.findById(Id.from(PERSON_ID))).thenReturn(Optional.of(person));

        PersonUseCaseOutput output = findPersonUseCase.execute(input);

        assertEquals(person.getId().value(), output.personId());
        assertEquals(person.getName().value(), output.name());
        assertEquals(person.getAge().value(), output.age());
        assertEquals(person.getAddress().getZipCode().value(), output.zipCode());
        assertEquals(person.getAddress().getState().value(), output.state());
        assertEquals(person.getAddress().getCity().value(), output.city());
        assertEquals(person.getAddress().getNeighborhood().value(), output.neighborhood());
        assertEquals(person.getAddress().getStreet().value(), output.street());
        assertEquals(person.getAddress().getNumber().value(), output.streetNumber());
        assertEquals(person.getPhone().getDdd().value(), output.ddd());
        assertEquals(person.getPhone().getNumber().value(), output.phoneNumber());
        assertEquals(person.getScore().value(), output.score());

        verify(repositoryPort, times(1)).findById(Id.from(PERSON_ID));
    }

    @Test
    void shouldThrowException_WhenPersonDoesNotExist() {
        when(repositoryPort.findById(Id.from(PERSON_ID))).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> findPersonUseCase.execute(input));

        verify(repositoryPort, times(1)).findById(Id.from(PERSON_ID));
    }
}