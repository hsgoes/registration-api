package com.serasaexperian.registration.api.infrastructure.handler;

import org.springframework.http.HttpStatusCode;

public record ErrorResponse(HttpStatusCode statusCode, String message) {
    public ErrorResponse(HttpStatusCode statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
