package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.infrastructure.adapters.repository.SpringDataUserRepository;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.UserRole;
import com.serasaexperian.registration.api.infrastructure.adapters.repository.entity.UserEntity;
import com.serasaexperian.registration.api.infrastructure.request.LoginDTO;
import com.serasaexperian.registration.api.infrastructure.request.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements AuthAPI {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SpringDataUserRepository repository;

    public ResponseEntity<?> login(LoginDTO loginDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity
                .ok()
                .build();
    }

    public ResponseEntity<?> register(RegisterDTO registerDTO) {
        if(this.repository.findByLogin(registerDTO.getLogin()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());

        UserEntity user = new UserEntity(registerDTO.getLogin(), encryptedPassword, UserRole.valueOf(registerDTO.getRole()));

        this.repository.save(user);

        return ResponseEntity
                .ok()
                .build();
    }
}
