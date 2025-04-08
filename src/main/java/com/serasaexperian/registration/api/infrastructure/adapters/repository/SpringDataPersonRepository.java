package com.serasaexperian.registration.api.infrastructure.adapters.repository;

import com.serasaexperian.registration.api.infrastructure.adapters.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataPersonRepository extends JpaRepository<PersonEntity, String>, JpaSpecificationExecutor<PersonEntity> {
}
