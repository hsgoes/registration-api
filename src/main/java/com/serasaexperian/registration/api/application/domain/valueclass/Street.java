package com.serasaexperian.registration.api.application.domain.valueclass;

public record Street(String value) {
    @Override
    public String toString() {
        return value;
    }
}