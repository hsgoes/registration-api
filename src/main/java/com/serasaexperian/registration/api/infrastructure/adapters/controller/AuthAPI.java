package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.infrastructure.request.LoginDTO;
import com.serasaexperian.registration.api.infrastructure.request.RegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1")
@Tag(name = "API para gerenciamento de pessoas")
public interface AuthAPI {

    @PostMapping("/login")
    @ApiResponse(responseCode = "200", description = "Ok")
    @Operation(
            summary = "Autenticar usuario",
            description = "Autentica um usuario e devolve um token de acesso"
    )
    ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDTO);

    @PostMapping("/register")
    @ApiResponse(responseCode = "200", description = "Ok")
    @Operation(
            summary = "Registrar um usuario",
            description = "Registra um usuario para acesso ao sistema"
    )
    ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO);
}
