package com.serasaexperian.registration.api.application.domain.valueclass;

import java.util.UUID;

public record Id(String value) {
    public Id {
        if (value == null || value.isEmpty() || !isValidUUID(value)) {
            throw new IllegalArgumentException("O valor " + value + " não é um UUID válido.");
        }
    }

    private static boolean isValidUUID(String value) {
        try {
            UUID.fromString(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static Id from(String id) {
        return new Id(id);
    }

    public static Id create() {
        return new Id(UUID.randomUUID().toString());
    }
}