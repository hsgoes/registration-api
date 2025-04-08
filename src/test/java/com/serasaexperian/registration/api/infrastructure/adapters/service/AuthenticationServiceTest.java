package com.serasaexperian.registration.api.infrastructure.adapters.service;

import com.serasaexperian.registration.api.infrastructure.adapters.repository.SpringDataUserRepository;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.entity.UserEntity;
import com.serasaexperian.registration.api.infrastructure.configuration.service.TokenService;
import com.serasaexperian.registration.api.infrastructure.request.LoginRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.RegisterRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private SpringDataUserRepository repository;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private AuthenticationService authenticationService;

    @Test
    void shouldReturnTokenWhen_LoginIsSuccessful() {
        var loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setLogin("user");
        loginRequestDTO.setPassword("password");

        var userEntity = new UserEntity("user", "password", null);

        var authToken = new UsernamePasswordAuthenticationToken(userEntity, "password");
        when(authenticationManager.authenticate(any())).thenReturn(authToken);
        when(tokenService.generateToken(userEntity)).thenReturn("mocked-token");

        var token = authenticationService.login(loginRequestDTO);

        assertEquals("mocked-token", token);
        verify(authenticationManager, times(1)).authenticate(any());
        verify(tokenService, times(1)).generateToken(userEntity);
    }

    @Test
    void shouldThrowException_WhenUserAlreadyExists() {
        var registerRequestDTO = new RegisterRequestDTO("user", "password", "USER");
        when(repository.findByLogin("user")).thenReturn(new UserEntity());
        
        assertThrows(RuntimeException.class, () -> authenticationService.register(registerRequestDTO));
        verify(repository, times(1)).findByLogin("user");
        verify(repository, never()).save(any());
    }

    @Test
    void shouldSaveUser_WhenRegisterIsSuccessful() throws Exception {
        var registerRequestDTO = new RegisterRequestDTO("user", "password", "USER");
        when(repository.findByLogin("user")).thenReturn(null);

        authenticationService.register(registerRequestDTO);

        verify(repository, times(1)).save(any(UserEntity.class));
    }
}