package com.serasaexperian.registration.api.application.domain.valueclass;

public record Neighborhood(String value) {
    @Override
    public String toString() {
        return value;
    }
}
