package com.serasaexperian.registration.api.infrastructure.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterDTO {
    private String login;
    private String password;
    private String role;
}
