package com.serasaexperian.registration.api.application.domain.valueclass;

public record State(String value) {
    @Override
    public String toString() {
        return value;
    }
}
