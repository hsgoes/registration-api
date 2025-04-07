package com.serasaexperian.registration.api.infrastructure.adapters.repository;

import com.serasaexperian.registration.api.infrastructure.adapters.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPersonRepository extends JpaRepository<PersonEntity, String> {
}
