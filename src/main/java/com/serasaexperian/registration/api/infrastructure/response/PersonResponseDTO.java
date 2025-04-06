package com.serasaexperian.registration.api.infrastructure.response;

import com.serasaexperian.registration.api.application.domain.entity.Person;

public class PersonResponseDTO {
    private String id;
    private String name;
    private String age;
    private String zipCode;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String phone;
    private Integer score;

    public PersonResponseDTO() {}

    public PersonResponseDTO(Person person) {
        this.id = person.getId().value();
        this.name = person.getName().value();
        this.age = person.getAge().value();
        this.zipCode = person.getAddress().getZipCode().value();
        this.state = person.getAddress().getState().toString();
        this.city = person.getAddress().getCity().value();
        this.neighborhood = person.getAddress().getNeighborhood().value();
        this.street = person.getAddress().getStreet().value();
        this.number = person.getAddress().getNumber().value();
        this.phone = person.getPhone().getDdd().value() + person.getPhone().getNumber().value();
        this.score = person.getScore().value();
    }
}
