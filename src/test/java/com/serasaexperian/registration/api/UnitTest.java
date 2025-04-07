package com.serasaexperian.registration.api;

import com.serasaexperian.registration.api.application.domain.ports.PersonRepositoryPort;
import com.serasaexperian.registration.api.application.domain.usecase.CreatePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.DeletePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.FindPersonUseCase;
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
    protected FindPersonUseCase findPersonUseCase;

    @InjectMocks
    protected DeletePersonUseCase deletePersonUseCase;


}
