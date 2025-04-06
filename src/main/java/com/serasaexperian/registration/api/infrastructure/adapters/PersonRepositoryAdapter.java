package com.serasaexperian.registration.api.infrastructure.adapters;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import com.serasaexperian.registration.api.infrastructure.adapters.entity.PersonEntity;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.SpringDataPersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryAdapter implements PersonRepositoryPort {

    private final SpringDataPersonRepository repository;

    public PersonRepositoryAdapter(SpringDataPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person createPerson(Person person) {
        var entity = new PersonEntity(person);

        try {
            var savedEntity = repository.save(entity);

            return savedEntity.toDomain();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao salvar a pessoa: " + e.getMessage(), e);
        }
    }

    @Override
    public Person getPerson(Id id) {
        var entity = repository.findById(id.value());

        try {
            return entity
                    .map(PersonEntity::toDomain)
                    .orElseThrow(() -> new Exception("Pessoa com o id " + id.value() + " não encontrada."));
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao buscar a pessoa: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletePerson(Id id) {
        try {
            repository.deleteById(id.value());
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao deletar a pessoa: " + e.getMessage(), e);
        }
    }

    @Override
    public Person updatePerson(Id id, String name, String email, String phoneNumber, String address) {
        return null;
    }
}
