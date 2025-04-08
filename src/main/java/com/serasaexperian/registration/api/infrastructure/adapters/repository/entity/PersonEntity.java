package com.serasaexperian.registration.api.infrastructure.adapters.repository.entity;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Getter
public class PersonEntity {
    @jakarta.persistence.Id
    private String id;
    private String name;
    private String age;
    private String score;
    @Setter
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private AddressEntity address;
    @Setter
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private PhoneEntity phone;

    public PersonEntity() {}

    public PersonEntity(Person person) {
        this.id = person.getId().value();
        this.name = person.getName().value();
        this.age = person.getAge().value();
        this.score = person.getScore().value().toString();
        this.address = new AddressEntity(person.getAddress(), this);
        this.phone = new PhoneEntity(person.getPhone(), this);
    }

    public Person toDomain() {
        return Person.from(
                Id.from(this.id),
                this.name,
                this.age,
                address.toDomain(),
                 phone.toDomain(),
                Integer.parseInt(this.score)
        );
    }
}