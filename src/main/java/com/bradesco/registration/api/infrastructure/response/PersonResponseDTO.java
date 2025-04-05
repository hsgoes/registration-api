package com.bradesco.registration.api.infrastructure.response;

public class PersonResponseDTO {
    private String id;
    private String name;
    private String age;
    private String zipCode;
    private String state;
    private String city;
    private String neighborhood;
    private String address;
    private String phone;
    private Integer score;

    public PersonResponseDTO() {}

    public PersonResponseDTO(String id, String name, String age, String zipCode, String state, String city, String neighborhood, String address, String phone, Integer score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.address = address;
        this.phone = phone;
        this.score = score;
    }
}
