package com.serasaexperian.registration.api.application.domain.valueclass;

public record Name(String value) {
    @Override
    public String toString() {
        return value;
    }
}