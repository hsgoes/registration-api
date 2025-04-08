package com.serasaexperian.registration.api.infrastructure.adapters.client;

import com.serasaexperian.registration.api.infrastructure.response.ExternalServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "externalServiceClient",
    url = "${via-cep.api.base-url}"
)
public interface VIACepClient {
    @GetMapping(
        value = "/{zipCode}/json",
        consumes = "application/json",
        produces = "application/json"
    )
    ResponseEntity<ExternalServiceResponse> getAddressByZipCode(@PathVariable String zipCode);
}
