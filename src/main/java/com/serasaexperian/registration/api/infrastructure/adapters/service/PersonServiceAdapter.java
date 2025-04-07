package com.serasaexperian.registration.api.infrastructure.adapters.service;

import com.serasaexperian.registration.api.application.domain.entity.Person;
import com.serasaexperian.registration.api.application.domain.ports.ExternalServicePort;
import com.serasaexperian.registration.api.application.domain.ports.PersonServicePort;
import com.serasaexperian.registration.api.application.domain.usecase.CreatePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.DeletePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.FindPersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.UpdatePersonUseCase;
import com.serasaexperian.registration.api.application.domain.usecase.input.CreatePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.input.DeletePersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.input.FindPersonUseCaseInput;
import com.serasaexperian.registration.api.application.domain.usecase.input.UpdatePersonUseCaseInput;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.UpdatePersonRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceAdapter implements PersonServicePort {

    private final CreatePersonUseCase createPersonUseCase;
    private final FindPersonUseCase findPersonUseCase;
    private final UpdatePersonUseCase updatePersonUseCase;
    private final DeletePersonUseCase deletePersonUseCase;
    private final ExternalServicePort externalServicePort;

    public PersonServiceAdapter(
            CreatePersonUseCase createPersonUseCase,
            FindPersonUseCase findPersonUseCase, UpdatePersonUseCase updatePersonUseCase,
            DeletePersonUseCase deletePersonUseCase,
            ExternalServicePort externalServicePort
    ) {
        this.createPersonUseCase = createPersonUseCase;
        this.findPersonUseCase = findPersonUseCase;
        this.updatePersonUseCase = updatePersonUseCase;
        this.deletePersonUseCase = deletePersonUseCase;
        this.externalServicePort = externalServicePort;
    }

    @Override
    public Person createPerson(CreatePersonRequestDTO requestDTO) {
        var externalServiceResponse = externalServicePort.getAddressByZipCode(requestDTO.getZipCode());

        var input =
            new CreatePersonUseCaseInput(
                requestDTO.getName(),
                requestDTO.getAge(),
                requestDTO.getZipCode(),
                externalServiceResponse.getEstado(),
                externalServiceResponse.getLocalidade(),
                externalServiceResponse.getBairro(),
                externalServiceResponse.getLogradouro(),
                requestDTO.getNumber(),
                requestDTO.getDdd(),
                requestDTO.getPhoneNumber(),
                requestDTO.getScore()
        );

        var output = createPersonUseCase.execute(input);

        return output.toPerson();
    }

    @Override
    public Person getPerson(String id) {
        var input = new FindPersonUseCaseInput(id);

        var output = findPersonUseCase.execute(input);

        return output.toPerson();
    }

    @Override
    public void deletePerson(String id) {
        deletePersonUseCase.execute(new DeletePersonUseCaseInput(id));
    }

    @Override
    public Person updatePerson(String id, UpdatePersonRequestDTO updatePersonRequestDTO) {
        var externalServiceResponse = externalServicePort.getAddressByZipCode(updatePersonRequestDTO.getZipCode());

        var input =
            new UpdatePersonUseCaseInput(
                id,
                updatePersonRequestDTO.getName(),
                updatePersonRequestDTO.getAge(),
                updatePersonRequestDTO.getZipCode(),
                externalServiceResponse.getEstado(),
                externalServiceResponse.getLocalidade(),
                externalServiceResponse.getBairro(),
                externalServiceResponse.getLogradouro(),
                updatePersonRequestDTO.getNumber(),
                updatePersonRequestDTO.getDdd(),
                updatePersonRequestDTO.getPhoneNumber(),
                updatePersonRequestDTO.getScore()
        );

        var output = updatePersonUseCase.execute(input);

        return output.toPerson();
    }

}
