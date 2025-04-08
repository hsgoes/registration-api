package com.serasaexperian.registration.api.infrastructure.adapters.service;

import com.serasaexperian.registration.api.UnitTest;
import com.serasaexperian.registration.api.infrastructure.response.ExternalServiceResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ExternalServiceAdapterTest extends UnitTest {

    @InjectMocks
    private ExternalServiceAdapter externalServiceAdapter;

    @Test
    void shouldReturnAddressByZipCode_WhenZipCodeIsValid() {
        ExternalServiceResponse addressResponse =
            new ExternalServiceResponse(
                "01001-000",
                "Rua Exemplo",
                "Complemento Exemplo",
                "Unidade Exemplo",
                "Centro",
                "São Paulo",
                "SP",
                "São Paulo",
                "Região Exemplo",
                "1234567",
                "1234",
                "11",
                "1234"
            );

        when(viaCepClient.getAddressByZipCode(anyString()))
                .thenReturn(ResponseEntity.ok(addressResponse));

        ExternalServiceResponse response = externalServiceAdapter.getAddressByZipCode("01001-000");

        assertEquals("01001-000", response.getCep());
        assertEquals("Rua Exemplo", response.getLogradouro());
        assertEquals("Complemento Exemplo", response.getComplemento());
        assertEquals("Unidade Exemplo", response.getUnidade());
        assertEquals("Centro", response.getBairro());
        assertEquals("São Paulo", response.getLocalidade());
        assertEquals("SP", response.getUf());
        assertEquals("São Paulo", response.getEstado());
        assertEquals("Região Exemplo", response.getRegiao());
        assertEquals("1234567", response.getIbge());
        assertEquals("1234", response.getGia());
        assertEquals("11", response.getDdd());
        assertEquals("1234", response.getSiafi());
    }
}