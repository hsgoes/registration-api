package com.serasaexperian.registration.api.infrastructure.configuration;

import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.CreatePersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreatePersonUseCase createPersonUseCase(PersonRepositoryPort repositoryPort) {
        return new CreatePersonUseCase(repositoryPort);
    }
}
