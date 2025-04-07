package com.serasaexperian.registration.api.infrastructure.adapters.service;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.ports.ExternalServicePort;
import com.serasaexperian.registration.api.application.domain.usecase.CreatePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.DeletePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.FindPersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.UpdatePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.input.CreatePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.input.DeletePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.input.FindPersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.input.UpdatePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.output.PersonUseCaseOutput;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.UpdatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.ExternalServiceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PersonServiceAdapterTest {
    private static final String PERSON_ID = "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";

    @Mock
    private CreatePersonUseCase createPersonUseCase;

    @Mock
    private FindPersonUseCase findPersonUseCase;

    @Mock
    private UpdatePersonUseCase updatePersonUseCase;

    @Mock
    private DeletePersonUseCase deletePersonUseCase;

    @Mock
    private ExternalServicePort externalServicePort;

    @InjectMocks
    private PersonServiceAdapter personServiceAdapter;

    private CreatePersonRequestDTO createPersonRequestDTO;
    private UpdatePersonRequestDTO updatePersonRequestDTO;
    private Person person;
    private PersonUseCaseOutput personUseCaseOutput;
    private ExternalServiceResponse externalResponse;

    @BeforeEach
    void setUp() {
        externalResponse =
            new ExternalServiceResponse(
                "12345678",
                "Rua A",
                "Apto 101",
                "A",
                "Centro",
                "São Paulo",
                "SP",
                "São Paulo",
                "Região Sudeste",
                "1234567",
                "1234",
                "11",
                "1234"
            );

        createPersonRequestDTO =
            new CreatePersonRequestDTO(
                "Joao Silva",
                "30",
                "12345678",
                "10",
                900,
                "11",
                "912345678"
            );

        updatePersonRequestDTO =
            new UpdatePersonRequestDTO(
                "Joao Silva",
                "30",
                "12345678",
                "10",
                900,
                "11",
                "912345678"
            );

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
        personUseCaseOutput = new PersonUseCaseOutput(person);

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreatePerson_WhenInputIsValid() {
        when(externalServicePort.getAddressByZipCode(createPersonRequestDTO.getZipCode())).thenReturn(externalResponse);
        when(createPersonUseCase.execute(any(CreatePersonUseCaseInput.class))).thenReturn(personUseCaseOutput);

        Person result = personServiceAdapter.createPerson(createPersonRequestDTO);

        assertValues(result);

        verify(createPersonUseCase, times(1)).execute(any(CreatePersonUseCaseInput.class));
    }

    @Test
    void shouldGetPerson_WhenIdIsValid() {
        var input = new FindPersonUseCaseInput("123");

        when(findPersonUseCase.execute(input)).thenReturn(personUseCaseOutput);

        Person result = personServiceAdapter.getPerson("123");

        assertValues(result);


        verify(findPersonUseCase, times(1)).execute(any(FindPersonUseCaseInput.class));
    }

    @Test
    void shouldDeletePerson_WhenIdIsValid() {
        doNothing().when(deletePersonUseCase).execute(any(DeletePersonUseCaseInput.class));

        personServiceAdapter.deletePerson("123");

        verify(deletePersonUseCase, times(1)).execute(any(DeletePersonUseCaseInput.class));
    }

    @Test
    void shouldUpdatePerson_WhenInputIsValid() {
        when(externalServicePort.getAddressByZipCode(updatePersonRequestDTO.getZipCode())).thenReturn(externalResponse);
        when(updatePersonUseCase.execute(any(UpdatePersonUseCaseInput.class))).thenReturn(personUseCaseOutput);

        Person result = personServiceAdapter.updatePerson("123", updatePersonRequestDTO);

        assertValues(result);

        verify(updatePersonUseCase, times(1)).execute(any(UpdatePersonUseCaseInput.class));
    }

    private void assertValues(Person result) {
        assertNotNull(result.getId().value());
        assertEquals(person.getName(), result.getName());
        assertEquals(person.getAge(), result.getAge());
        assertEquals(person.getAddress().getZipCode(), result.getAddress().getZipCode());
        assertEquals(person.getAddress().getState(), result.getAddress().getState());
        assertEquals(person.getAddress().getCity(), result.getAddress().getCity());
        assertEquals(person.getAddress().getNeighborhood(), result.getAddress().getNeighborhood());
        assertEquals(person.getAddress().getStreet(), result.getAddress().getStreet());
        assertEquals(person.getAddress().getNumber(), result.getAddress().getNumber());
        assertEquals(person.getPhone().getDdd(), result.getPhone().getDdd());
        assertEquals(person.getPhone().getNumber(), result.getPhone().getNumber());
        assertEquals(person.getScore(), result.getScore());
    }
}