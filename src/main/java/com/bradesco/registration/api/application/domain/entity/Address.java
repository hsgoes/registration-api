package com.bradesco.registration.api.application.domain.entity;

import com.bradesco.registration.api.application.domain.valueclass.City;
import com.bradesco.registration.api.application.domain.valueclass.Neighborhood;
import com.bradesco.registration.api.application.domain.valueclass.State;
import com.bradesco.registration.api.application.domain.valueclass.ZipCode;

public class Address {
    private final ZipCode zipCode;
    private final State state;
    private final City city;
    private final Neighborhood neighborhood;

    private Address(
            ZipCode zipCode,
            State state,
            City city,
            Neighborhood neighborhood
    ) {
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
                zipCode,
                state,
                city,
                neighborhood
        );
    }

    public static Address from(
            ZipCode zipCode,
            State state,
            City city,
            Neighborhood neighborhood
    ) {
        return new Address(
                zipCode,
                state,
                city,
                neighborhood
        );
    }
}
