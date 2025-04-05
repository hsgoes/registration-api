package com.bradesco.registration.api.application.domain.valueclass;

public record Phone(DDD ddd, Number number) {
    @Override
    public String toString() {
        return ddd + number.toString();
    }
}
