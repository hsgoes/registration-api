package com.serasaexperian.registration.api.infrastructure.adapters.entity;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String zipCode;
    private String state;
    private String city;
    private String neighborhood;

    public AddressEntity() {
    }

    public AddressEntity(Address address) {
        this.id = address.getId();
        this.zipCode = address.getZipCode().value();
        this.state = address.getState().value();
        this.city = address.getCity().value();
        this.neighborhood = address.getNeighborhood().value();
    }

    public Address toDomain() {
        return Address.from(
                this.id,
                this.zipCode,
                this.state,
                this.city,
                this.neighborhood

        );
    }
}
