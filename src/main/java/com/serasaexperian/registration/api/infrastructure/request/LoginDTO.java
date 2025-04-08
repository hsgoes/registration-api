package com.serasaexperian.registration.api.infrastructure.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class LoginDTO {
    @Schema(description = "Login do usuário", example = "serasaexperian")
    private String login;
    @Schema(description = "Senha do usuário", example = "serasaexperian"    )
    private String password;
}
