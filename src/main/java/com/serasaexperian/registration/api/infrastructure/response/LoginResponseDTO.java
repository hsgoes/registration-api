package com.serasaexperian.registration.api.infrastructure.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class  LoginResponseDTO {
    private String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
