package com.bradesco.registration.api.application.domain.valueclass;

public record City(String value) {
    @Override
    public String toString() {
        return value;
    }
}
