package com.bradesco.registration.api.application.domain.entity;

import com.bradesco.registration.api.application.domain.valueclass.*;

import java.util.UUID;

public class Person {
    private final String id;
    private final Name name;
    private final Age age;
    private final Address address;
    private final Phone phone;
    private final Score score;

    private Person(String id,
                   Name name,
                   Age age,
                   Address address,
                   Phone phone,
                   Score score
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.score = score;
    }

    public static Person create(
            Name name,
            Age age,
            Address address,
            Phone phone,
            Score score
    ) {
        return new Person(
                UUID.randomUUID().toString(),
                name,
                age,
                address,
                phone,
                score
        );
    }

    public static Person from(
            String id,
            Name name,
            Age age,
            Address address,
            Phone phone,
            Score score
    ) {
        return new Person(
                id,
                name,
                age,
                address,
                phone,
                score
        );
    }
}
