package com.serasaexperian.registration.api.application.domain.valueclass;

import java.util.Objects;

public record Age(String value) {
    @Override
    public String toString() {
        return value;
    }
}
