package com.serasaexperian.registration.api.infrastructure.adapters.repository;

import com.serasaexperian.registration.api.infrastructure.adapters.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, String> {
    UserDetails findByLogin(String login);
}
