package com.serasaexperian.registration.api.application.domain.valueclass;

public record PhoneNumber(String value) {
    @Override
    public String toString() {
        return value;
    }
}
