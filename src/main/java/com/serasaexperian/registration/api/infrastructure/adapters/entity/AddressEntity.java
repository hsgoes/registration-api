package com.serasaexperian.registration.api.infrastructure.adapters.entity;

import com.serasaexperian.registration.api.application.domain.entity.Address;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "addresses")
@Getter
public class AddressEntity {
    @jakarta.persistence.Id
    private String id;
    private String zipCode;
    private String state;
    private String city;
    private String neighborhood;

    public AddressEntity() {
    }

    public AddressEntity(Address address) {
        this.id = address.getId().value();
        this.zipCode = address.getZipCode().value();
        this.state = address.getState().value();
        this.city = address.getCity().value();
        this.neighborhood = address.getNeighborhood().value();
    }

    public Address toDomain() {
        return Address.from(
                Id.from(this.id),
                this.zipCode,
                this.state,
                this.city,
                this.neighborhood

        );
    }
}
