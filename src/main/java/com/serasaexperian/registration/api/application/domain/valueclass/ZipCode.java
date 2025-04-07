package com.serasaexperian.registration.api.application.domain.valueclass;

public record ZipCode(String value) {
    @Override
    public String toString() {
        return value;
    }
}
