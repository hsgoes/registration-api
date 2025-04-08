package com.serasaexperian.registration.api.infrastructure.adapters.repository.entity;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Getter
@NoArgsConstructor
public class AddressEntity {
    @jakarta.persistence.Id
    private String id;
    @OneToOne
    @MapsId("id")
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    private String zipCode;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;

    public AddressEntity(Address address, PersonEntity person) {
        this.id = person.getId();
        this.person = person;
        this.zipCode = address.getZipCode().value();
        this.state = address.getState().value();
        this.city = address.getCity().value();
        this.neighborhood = address.getNeighborhood().value();
        this.street = address.getStreet().value();
        this.number = address.getNumber().value();
    }

    public Address toDomain() {
        return Address.from(
            this.zipCode,
            this.state,
            this.city,
            this.neighborhood,
            this.street,
            this.number
        );
    }
}

