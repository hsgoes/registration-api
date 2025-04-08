package com.serasaexperian.registration.api.application.domain.ports;

import com.serasaexperian.registration.api.infrastructure.request.LoginRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.RegisterRequestDTO;

public interface AuthenticationServicePort {
    String login(LoginRequestDTO loginRequestDTO);

    void register(RegisterRequestDTO registerRequestDTO) throws Exception;
}
