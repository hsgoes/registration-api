package com.serasaexperian.registration.api.infrastructure.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonFilter {
    @Schema(description = "Nome da pessoa", example = "João da Silva")
    private String name;
    @Schema(description = "Idade da pessoa", example = "25")
    private String age;
    @Schema(description = "Número do CPF da pessoa", example = "12345678909")
    private String zipCode;
}
