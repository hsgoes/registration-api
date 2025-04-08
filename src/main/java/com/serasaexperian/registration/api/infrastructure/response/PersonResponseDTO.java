package com.serasaexperian.registration.api.infrastructure.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.serasaexperian.registration.api.application.domain.entity.Person;

public class PersonResponseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private String age;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("state")
    private String state;

    @JsonProperty("city")
    private String city;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("street")
    private String street;

    @JsonProperty("number")
    private String number;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("scoreDescription")
    private String scoreDescription;

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
        this.scoreDescription = chooseDescription(score);
    }

    private String chooseDescription(Integer score) {
        return switch (score) {
            default -> {
                if (score >= 0 && score <= 200) yield "Insuficiente";
                else if (score >= 201 && score <= 500) yield "Inaceitável";
                else if (score >= 501 && score <= 700) yield "Aceitável";
                else if (score >= 701 && score <= 1000) yield "Recomendável";
                else yield "Fora do intervalo";
            }
        };
    }
}