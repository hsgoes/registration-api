package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.application.domain.ports.AuthenticationServicePort;
import com.serasaexperian.registration.api.infrastructure.request.LoginRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.RegisterRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements AuthAPI {

    private final AuthenticationServicePort authenticationServicePort;

    public AuthenticationController(AuthenticationServicePort authenticationServicePort) {
        this.authenticationServicePort = authenticationServicePort;
    }

    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO) {
        var token = authenticationServicePort.login(loginRequestDTO);

        return ResponseEntity
                .ok(new LoginResponseDTO(token));
    }

    public ResponseEntity<?> register(RegisterRequestDTO registerRequestDTO) throws Exception {
        authenticationServicePort.register(registerRequestDTO);

        return ResponseEntity
                .ok()
                .build();
    }
}
