package com.serasaexperian.registration.api.infrastructure.configuration;

import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.CreatePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.DeletePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.FindPersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.UpdatePersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreatePersonUseCase createPersonUseCase(PersonRepositoryPort repositoryPort) {
        return new CreatePersonUseCase(repositoryPort);
    }

    @Bean
    public FindPersonUseCase findPersonUseCase(PersonRepositoryPort repositoryPort) {
        return new FindPersonUseCase(repositoryPort);
    }

    @Bean
    public UpdatePersonUseCase updatePersonUseCase(PersonRepositoryPort repositoryPort) {
        return new UpdatePersonUseCase(repositoryPort);
    }

    @Bean
    public DeletePersonUseCase deletePersonUseCase(PersonRepositoryPort repositoryPort) {
        return new DeletePersonUseCase(repositoryPort);
    }
}
