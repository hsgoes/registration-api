package com.serasaexperian.registration.api.infrastructure.adapters.entity;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "persons")
public class PersonEntity {
    @jakarta.persistence.Id
    private String id;
    private String name;
    private String age;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", nullable = false)
    private PhoneEntity phone;
    private String score;

    public PersonEntity() {
    }

    public PersonEntity(Person person) {
        this.id = person.getId().value();
        this.name = person.getName().value();
        this.age = person.getAge().value();
        this.address = new AddressEntity(person.getAddress());
        this.phone = new PhoneEntity(person.getPhone());
        this.score = person.getScore().value().toString();
    }

    public Person toDomain() {
        return Person.from(
                Id.from(this.id),
                this.name,
                this.age,
                new AddressEntity().toDomain(),
                new PhoneEntity().toDomain(),
                Integer.valueOf(this.score)
        );
    }
}
