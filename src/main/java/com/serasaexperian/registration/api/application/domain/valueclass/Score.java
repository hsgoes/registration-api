package com.serasaexperian.registration.api.application.domain.valueclass;

public record Score(Integer value) {
    public Score {
        if (value < 0 || value > 1000) {
            throw new IllegalArgumentException("O Score deve ser um valor entre 0 e 1000");
        }
    }
    @Override
    public String toString() {
        return value.toString();
    }
}
