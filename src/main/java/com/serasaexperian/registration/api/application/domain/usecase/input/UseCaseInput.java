package com.serasaexperian.registration.api.application.domain.usecase.input;

public interface UseCaseInput {
    default <T> T requireNonNull(T obj, String message) {
        if (obj == null || obj.toString().trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return obj;
    }
}
