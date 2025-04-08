package com.serasaexperian.registration.api.infrastructure.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePersonRequestDTO {
    @Schema(description = "Nome da pessoa", example = "João da Silva")
    @NotNull(message = "O nome não pode ser vazio")
    private String name;
    @Schema(description = "Idade da pessoa", example = "25")
    @NotNull(message = "A idade não pode ser vazia")
    private String age;
    @Schema(description = "Cep da residencia", example = "12345678")
    @NotNull(message = "O cep não pode ser vazio")
    private String zipCode;
    @Schema(description = "Numero da residencia", example = "123")
    @NotNull(message = "O numero da residencia não pode ser vazio")
    private String number;
    @Schema(description = "Score da pessoa", example = "1000")
    @NotNull(message = "O score não pode ser vazio")
    private Integer score;
    @Schema(description = "DDD do telefone", example = "11")
    @NotNull(message = "O ddd não pode ser vazio")
    private String ddd;
    @Schema(description = "Numero do telefone", example = "999999999")
    @NotNull(message = "O telefone não pode ser vazio")
    private String phoneNumber;
}
