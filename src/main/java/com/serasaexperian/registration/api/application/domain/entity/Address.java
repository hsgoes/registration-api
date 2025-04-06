package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.*;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Address {
    private final Id id;
    private final ZipCode zipCode;
    private final State state;
    private final City city;
    private final Neighborhood neighborhood;

    private Address(
            Id id,
            ZipCode zipCode,
            State state,
            City city,
            Neighborhood neighborhood
    ) {
        this.id = id;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public static Address create(
            ZipCode zipCode,
            State state,
            City city,
            Neighborhood neighborhood
    ) {
        return new Address(
                Id.create(),
                zipCode,
                state,
                city,
                neighborhood
        );
    }

    public static Address from(
            Id id,
            String zipCode,
            String state,
            String city,
            String neighborhood
    ) {
        return new Address(
                id,
                new ZipCode(zipCode),
                new State(state),
                new City(city),
                new Neighborhood(neighborhood)
        );
    }
}
