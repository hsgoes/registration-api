package com.serasaexperian.registration.api.application.domain.valueclass;

public record Age(String value) {
    @Override
    public String toString() {
        return value;
    }
}
