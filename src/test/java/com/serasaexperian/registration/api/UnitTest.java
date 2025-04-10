package com.serasaexperian.registration.api;

import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.CreatePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.DeletePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.UpdatePersonUseCase;
import com.serasaexperian.registration.api.infrastructure.adapters.client.VIACepClient;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UnitTest {
    @Mock
    protected PersonRepositoryPort repositoryPort;

    @InjectMocks
    protected CreatePersonUseCase createPersonUseCase;

    @InjectMocks
    protected DeletePersonUseCase deletePersonUseCase;

    @InjectMocks
    protected UpdatePersonUseCase updatePersonUseCase;

    @Mock
    protected VIACepClient viaCepClient;
}
