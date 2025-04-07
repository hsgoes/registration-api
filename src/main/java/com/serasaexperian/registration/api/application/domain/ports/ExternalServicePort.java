package com.serasaexperian.registration.api.application.domain.ports;

import com.serasaexperian.registration.api.infrastructure.response.ExternalServiceResponse;

public interface ExternalServicePort {
    ExternalServiceResponse getAddressByZipCode(String zipCode);
}
