package com.bradesco.registration.api.application.domain.valueclass;

public record DDD(String value) {
    public DDD {
        if (!value.matches("\\d{2}")) {
            throw new IllegalArgumentException("O DDD deve conter 2 digitos");
        }
    }
    @Override
    public String toString() {
        return value;
    }
}
