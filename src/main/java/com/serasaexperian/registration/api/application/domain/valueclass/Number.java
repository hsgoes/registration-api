package com.serasaexperian.registration.api.application.domain.valueclass;

public record Number(String value) {
    @Override
    public String toString() {
        return value;
    }
}
