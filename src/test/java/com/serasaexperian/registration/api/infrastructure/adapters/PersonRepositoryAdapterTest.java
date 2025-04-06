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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    private static final String ADDRESS_ID = "5ce5b33b-2e64-40f9-acb4-6aa1edc953c1";

    @BeforeEach
    void setUp() {
        person = Person.from(
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
    void shouldGetPerson_WhenValidIdIsProvided() {
        when(repository.findById(person.getId().value())).thenReturn(Optional.of(personEntity));

        var result = adapter.findById(person.getId());

        assertNotNull(result);
        verify(repository, times(1)).findById(person.getId().value());
    }

    @Test
    void shouldDelete_WhenValidIdIsProvided() {
        doNothing().when(repository).deleteById(person.getId().value());

        assertDoesNotThrow(() -> adapter.delete(person.getId()));
        verify(repository, times(1)).deleteById(person.getId().value());
    }

    @Test
    void shouldUpdatePersonWhenValidDataIsProvided() {
        // Implementar o teste quando o método updatePerson estiver implementado
    }
}