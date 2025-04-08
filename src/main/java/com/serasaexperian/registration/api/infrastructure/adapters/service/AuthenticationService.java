package com.serasaexperian.registration.api.infrastructure.adapters.service;

import com.serasaexperian.registration.api.application.domain.ports.AuthenticationServicePort;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.SpringDataUserRepository;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.UserRole;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.entity.UserEntity;
import com.serasaexperian.registration.api.infrastructure.configuration.service.TokenService;
import com.serasaexperian.registration.api.infrastructure.request.LoginRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.RegisterRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthenticationServicePort {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SpringDataUserRepository repository;

    @Autowired
    private TokenService tokenService;

    @Override
    public String login(LoginRequestDTO loginRequestDTO) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.getLogin(), loginRequestDTO.getPassword());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            return tokenService.generateToken((UserEntity) auth.getPrincipal());

        } catch (Exception e) {
            throw new RuntimeException("Authentication failed", e);
        }
    }

    @Override
    public void register(RegisterRequestDTO registerRequestDTO) throws Exception {
        try {
            if(this.repository.findByLogin(registerRequestDTO.getLogin()) != null)
                throw new Exception("User already exists");

            String encryptedPassword = new BCryptPasswordEncoder().encode(registerRequestDTO.getPassword());

            UserEntity user = new UserEntity(registerRequestDTO.getLogin(), encryptedPassword, UserRole.valueOf(registerRequestDTO.getRole()));

            this.repository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Registration failed", e);
        }
    }
}
