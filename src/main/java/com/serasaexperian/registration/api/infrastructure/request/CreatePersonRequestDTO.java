package com.serasaexperian.registration.api.infrastructure.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePersonRequestDTO {
    @NotNull(message = "O nome não pode ser vazio")
    private String name;
    @NotNull(message = "A idade não pode ser vazia")
    private String age;
    @NotNull(message = "O cep não pode ser vazio")
    private String zipCode;
    @NotNull(message = "O numero da residencia não pode ser vazio")
    private String number;
    @NotNull(message = "O score não pode ser vazio")
    private Integer score;
    @NotNull(message = "O ddd não pode ser vazio")
    private String ddd;
    @NotNull(message = "O telefone não pode ser vazio")
    private String phoneNumber;
}
