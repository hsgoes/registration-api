package com.serasaexperian.registration.api.infrastructure.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        return createErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return createErrorMessage(HttpStatus.BAD_REQUEST, "Erro de argumento inválido: " + ex.getMessage());
    }

    private ResponseEntity<ErrorResponse> createErrorMessage(HttpStatusCode statusCode, String message) {
        return ResponseEntity
                .status(statusCode)
                .body(new ErrorResponse(statusCode, message));
    }
}