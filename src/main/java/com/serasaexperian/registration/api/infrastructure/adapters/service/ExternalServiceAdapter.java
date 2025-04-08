package com.serasaexperian.registration.api.infrastructure.adapters.service;

import com.serasaexperian.registration.api.application.domain.ports.ExternalServicePort;
import com.serasaexperian.registration.api.infrastructure.adapters.client.VIACepClient;
import com.serasaexperian.registration.api.infrastructure.response.ExternalServiceResponse;
import org.springframework.stereotype.Component;

@Component
public class ExternalServiceAdapter implements ExternalServicePort {
    private final VIACepClient VIACepClient;

    public ExternalServiceAdapter(VIACepClient VIACepClient) {
        this.VIACepClient = VIACepClient;
    }

    @Override
    public ExternalServiceResponse getAddressByZipCode(String zipCode) {
        return VIACepClient.getAddressByZipCode(zipCode).getBody();
    }
}
