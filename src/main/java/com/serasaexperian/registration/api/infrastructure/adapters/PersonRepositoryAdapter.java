package com.serasaexperian.registration.api.infrastructure.adapters;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.entity.PersonEntity;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.SpringDataPersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryAdapter implements PersonRepositoryPort {

    private final SpringDataPersonRepository repository;

    public PersonRepositoryAdapter(SpringDataPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Person save(Person person) {
        var entity = new PersonEntity(person);

        try {
            var savedEntity = repository.save(entity);

            return savedEntity.toDomain();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao salvar a pessoa: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Person> findById(Id id) {
        try {
            var entity = repository.findById(id.value());
            return entity.map(PersonEntity::toDomain);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao buscar a pessoa: " + e.getMessage(), e);
        }
    }

    @Override
    public Page<Person> findAll(Specification<PersonEntity> specification, Pageable pageable) {
        try {
            return repository.findAll(specification, pageable).map(PersonEntity::toDomain);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao buscar todas as pessoas: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Id id) {
        try {
            repository.deleteById(id.value());
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao deletar a pessoa: " + e.getMessage(), e);
        }
    }
}
