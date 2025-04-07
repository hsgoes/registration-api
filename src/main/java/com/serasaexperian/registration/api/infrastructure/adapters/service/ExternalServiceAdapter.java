package com.serasaexperian.registration.api.infrastructure.adapters.service;

import com.serasaexperian.registration.api.application.domain.ports.ExternalServicePort;
import com.serasaexperian.registration.api.infrastructure.adapters.client.ExternalServiceClient;
import com.serasaexperian.registration.api.infrastructure.response.ExternalServiceResponse;
import org.springframework.stereotype.Component;

@Component
public class ExternalServiceAdapter implements ExternalServicePort {
    private final ExternalServiceClient externalServiceClient;

    public ExternalServiceAdapter(ExternalServiceClient externalServiceClient) {
        this.externalServiceClient = externalServiceClient;
    }

    @Override
    public ExternalServiceResponse getAddressByZipCode(String zipCode) {
        return externalServiceClient.getAddressByZipCode(zipCode).getBody();
    }
}
