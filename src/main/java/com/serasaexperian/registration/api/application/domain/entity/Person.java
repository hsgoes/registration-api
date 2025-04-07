package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.Age;
import com.serasaexperian.registration.api.application.domain.valueclass.Id;
import com.serasaexperian.registration.api.application.domain.valueclass.Name;
import com.serasaexperian.registration.api.application.domain.valueclass.Score;
import lombok.Getter;

@Getter
public class Person {
    private final Id id;
    private final Name name;
    private final Age age;
    private final Address address;
    private final Phone phone;
    private final Score score;

    private Person(Id id,
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
                Id.create(),
                name,
                age,
                address,
                phone,
                score
        );
    }

    public static Person from(
            Id id,
            String name,
            String age,
            Address address,
            Phone phone,
            Integer score
    ) {
        return new Person(
                id,
                new Name(name),
                new Age(age),
                address,
                phone,
                new Score(score)
        );
    }
}
