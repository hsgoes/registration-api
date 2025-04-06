package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.City;
import com.serasaexperian.registration.api.application.domain.valueclass.Neighborhood;
import com.serasaexperian.registration.api.application.domain.valueclass.State;
import com.serasaexperian.registration.api.application.domain.valueclass.ZipCode;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Address {
    private final String id;
    private final ZipCode zipCode;
    private final State state;
    private final City city;
    private final Neighborhood neighborhood;

    private Address(
            String id,
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
                UUID.randomUUID().toString(),
                zipCode,
                state,
                city,
                neighborhood
        );
    }

    public static Address from(
            String id,
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
