package com.serasaexperian.registration.api.application.domain.valueclass;

import java.util.UUID;

public record Id(String value) {
    public static Id from(String id) {
        try {
            return new Id(UUID.fromString(id).toString());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("O valor " + id + " não é um UUID válido.", e);
        }
    }

    public static Id create() {
        return new Id(UUID.randomUUID().toString());
    }
}
