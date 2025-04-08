package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.application.domain.ports.AuthenticationServicePort;
import com.serasaexperian.registration.api.infrastructure.request.LoginRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.RegisterRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.LoginResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthenticationControllerTest {

    private AuthenticationServicePort authenticationServicePort;
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        authenticationServicePort = mock(AuthenticationServicePort.class);
        authenticationController = new AuthenticationController(authenticationServicePort);
    }

    @Test
    void shouldReturnTokenWhenLoginIsSuccessful() {
        var loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setLogin("login");
        loginRequestDTO.setPassword("password");

        var expectedToken = "mocked-token";
        when(authenticationServicePort.login(loginRequestDTO)).thenReturn(expectedToken);

        var response = authenticationController.login(loginRequestDTO);

        verify(authenticationServicePort, times(1)).login(loginRequestDTO);

        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        assertEquals(expectedToken, Objects.requireNonNull(response.getBody()).getToken());

    }

    @Test
    void shouldRegisterUserWhenRegisterIsSuccessful() throws Exception {
        var registerRequestDTO = new RegisterRequestDTO("user", "password", "email@example.com");

        ResponseEntity<?> response = authenticationController.register(registerRequestDTO);

        verify(authenticationServicePort, times(1)).register(registerRequestDTO);

        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
    }
}