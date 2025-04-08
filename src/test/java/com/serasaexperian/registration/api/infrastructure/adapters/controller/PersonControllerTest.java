package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.ports.PersonServicePort;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.PersonFilter;
import com.serasaexperian.registration.api.infrastructure.request.UpdatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.PersonResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

    private static final String PERSON_ID = "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";

    @Mock
    private PersonServicePort servicePort;

    @InjectMocks
    private PersonController personController;

    private CreatePersonRequestDTO requestDTO;
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
                ), 900
            );

        requestDTO =
            new CreatePersonRequestDTO(
                "Joao Silva",
                "30",
                "12345678",
                "10",
                900,
                "11",
                "912345678"
            );
    }

    @Test
    void shouldCreatePerson_whenCreatePersonIsCalled() {
        when(servicePort.createPerson(requestDTO)).thenReturn(person);

        ResponseEntity<PersonResponseDTO> response = personController.createPerson(requestDTO);

        verify(servicePort, times(1)).createPerson(requestDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldGetAllPersons_whenGetAllPersonsIsCalled() {
        var personFilter = new PersonFilter();
        var pageable = PageRequest.of(0, 10);
        var persons = new PageImpl<>(List.of(person), pageable, 1);

        when(servicePort.getAll(personFilter, pageable)).thenReturn(persons);

        ResponseEntity<Page<PersonResponseDTO>> response = personController.getPersons(personFilter, pageable);

        verify(servicePort, times(1)).getAll(personFilter, pageable);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldDeletePerson_whenDeletePersonIsCalled() {
        doNothing().when(servicePort).deletePerson(PERSON_ID);

        ResponseEntity<?> response = personController.deletePerson(PERSON_ID);

        verify(servicePort, times(1)).deletePerson(PERSON_ID);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }


    @Test
    void shouldUpdatePerson_whenUpdatePersonIsCalled() {
        var updatePersonRequestDTO =
            new UpdatePersonRequestDTO(
                "Joao Silva",
                "30",
                "12345678",
                "10",
                900,
                "11",
                "912345678"
            );

        when(servicePort.updatePerson(PERSON_ID, updatePersonRequestDTO)).thenReturn(person);

        ResponseEntity<PersonResponseDTO> response = personController.updatePerson(PERSON_ID, updatePersonRequestDTO);

        verify(servicePort, times(1)).updatePerson(PERSON_ID, updatePersonRequestDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}