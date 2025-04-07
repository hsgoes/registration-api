package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.ports.PersonServicePort;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.PersonResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PersonControllerTest {

    private static final String PERSON_ID = "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";
    private static final String ADDRESS_ID = "5ce5b33b-2e64-40f9-acb4-6aa1edc953c1";

    @Mock
    private PersonServicePort servicePort;

    @InjectMocks
    private PersonCo personController;

    private CreatePersonRequestDTO requestDTO;
    private Person person;

    @BeforeEach
    public void setUp() {
        person =
            Person.from(
                Id.from(PERSON_ID),
                "Joao Silva",
                "30",
                Address.from(
                        Id.from(ADDRESS_ID),
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

        requestDTO = new CreatePersonRequestDTO();
        requestDTO.setName("Joao Silva");
        requestDTO.setAge("30");
        requestDTO.setZipCode("12345678");
        requestDTO.setScore(900);

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreatePerson_whenCreatePersonIsCalled() {
        when(servicePort.createPerson(requestDTO)).thenReturn(person);

        ResponseEntity<PersonResponseDTO> response = personController.createPerson(requestDTO);

        verify(servicePort, times(1)).createPerson(requestDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

//    @Test
//    public void shouldGetPerson_whenGetPersonIsCalled() {
//        ResponseEntity<PersonResponseDTO> response = personController.getPerson("1", "0", "10");
//
//        assertEquals(ResponseEntity.ok().build(), response);
//    }
//
//    @Test
//    public void shouldDeletePerson_whenDeletePersonIsCalled() {
//        ResponseEntity<?> response = personController.deletePerson();
//
//        assertEquals(ResponseEntity.ok().build(), response);
//    }
//
//    @Test
//    public void shouldUpdatePerson_whenUpdatePersonIsCalled() {
//        ResponseEntity<PersonResponseDTO> response = personController.updatePerson("1", requestDTO);
//
//        assertEquals(ResponseEntity.ok().build(), response);
//    }
}