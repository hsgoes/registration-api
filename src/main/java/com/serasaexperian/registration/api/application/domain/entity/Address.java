package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.*;
import lombok.Getter;

@Getter
public class Address {
    private final ZipCode zipCode;
    private final State state;
    private final City city;
    private final Neighborhood neighborhood;
    private final Street street;
    private final StreetNumber number;

    private Address(
            ZipCode zipCode,
            State state,
            City city,
            Neighborhood neighborhood,
            Street street,
            StreetNumber number
    ) {
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
    }

    public static Address create(
            ZipCode zipCode,
            State state,
            City city,
            Neighborhood neighborhood,
            Street street,
            StreetNumber number
    ) {
        return new Address(
                zipCode,
                state,
                city,
                neighborhood,
                street,
                number
        );
    }

    public static Address from(
            String zipCode,
            String state,
            String city,
            String neighborhood,
            String street,
            String number
    ) {
        return new Address(
                new ZipCode(zipCode),
                new State(state),
                new City(city),
                new Neighborhood(neighborhood),
                new Street(street),
                new StreetNumber(number)
        );
    }
}