package com.serasaexperian.registration.api.infrastructure.adapters;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.entity.Phone;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import com.serasaexperian.registration.api.infrastructure.adapters.entity.PersonEntity;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.SpringDataPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PersonRepositoryAdapterTest {

    @Mock
    private SpringDataPersonRepository repository;

    @InjectMocks
    private PersonRepositoryAdapter adapter;

    private Person person;
    private PersonEntity personEntity;

    private static final String PERSON_ID =  "a4abf7e9-a23f-46e0-8c3a-b8a418dc39c2";

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

        personEntity = new PersonEntity(person);

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSavePerson_WhenValidIsProvided() {
        when(repository.save(any(PersonEntity.class))).thenReturn(personEntity);

        Person result = adapter.save(person);

        assertNotNull(result);

        verify(repository, times(1)).save(any(PersonEntity.class));
    }

    @Test
    void shouldThrowException_WhenSaveFails() {
        when(repository.save(any(PersonEntity.class))).thenThrow(new RuntimeException("Error"));

        var exception = assertThrows(RuntimeException.class, () -> adapter.save(person));

        verify(repository, times(1)).save(any(PersonEntity.class));

        assertEquals("Ocorreu um erro ao salvar a pessoa: Error", exception.getMessage());
    }

    @Test
    void shouldGetPerson_WhenValidIdIsProvided() {
        when(repository.findById(person.getId().value())).thenReturn(Optional.of(personEntity));

        var result = adapter.findById(person.getId());

        assertNotNull(result);
        verify(repository, times(1)).findById(person.getId().value());
    }

    @Test
    void shouldThrowException_WhenGetPersonFails() {
        when(repository.findById(person.getId().value())).thenThrow(new RuntimeException("Error"));

        var exception = assertThrows(RuntimeException.class, () -> adapter.findById(person.getId()));

        verify(repository, times(1)).findById(person.getId().value());

        assertEquals("Ocorreu um erro ao buscar a pessoa: Error", exception.getMessage());
    }

    @Test
    void shouldDelete_WhenValidIdIsProvided() {
        doNothing().when(repository).deleteById(person.getId().value());

        assertDoesNotThrow(() -> adapter.delete(person.getId()));
        verify(repository, times(1)).deleteById(person.getId().value());
    }

    @Test
    void shouldThrowException_WhenDeleteFails() {
        doThrow(new RuntimeException("Error")).when(repository).deleteById(person.getId().value());

        var exeption = assertThrows(RuntimeException.class, () -> adapter.delete(person.getId()));

        verify(repository, times(1)).deleteById(person.getId().value());

        assertEquals("Ocorreu um erro ao deletar a pessoa: Error", exeption.getMessage());
    }

    @Test
    void shouldUpdatePersonWhenValidDataIsProvided() {
        // Implementar o teste quando o método updatePerson estiver implementado
    }
}