package com.serasaexperian.registration.api.application.domain.valueclass;

public record StreetNumber(String value) {
    @Override
    public String toString() {
        return value;
    }
}