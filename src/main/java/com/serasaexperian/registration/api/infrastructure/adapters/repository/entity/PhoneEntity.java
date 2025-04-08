package com.serasaexperian.registration.api.infrastructure.adapters.repository.entity;

import com.serasaexperian.registration.api.application.domain.entity.Phone;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "phones")
@Getter
public class PhoneEntity {
    @jakarta.persistence.Id
    private String id;
    @OneToOne
    @MapsId("id")
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    private String DDD;
    private String number;

    public PhoneEntity(Phone phone, PersonEntity person) {
        this.id = person.getId();
        this.person = person;
        this.DDD = phone.getDdd().value();
        this.number = phone.getNumber().value();
    }

    public Phone toDomain() {
        return Phone.from(
            this.DDD,
            this.number
        );
    }
}