package com.serasaexperian.registration.api.infrastructure.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePersonRequestDTO {
    @NotNull(message = "O nome da pessoa não pode ser vazio")
    private String name;
    @NotNull(message = "A idade da pessoa não pode ser vazia")
    private String age;
    @NotNull(message = "O cep da pessoa não pode ser vazio")
    private String zipCode;
    @NotNull(message = "O score da pessoa não pode ser vazio")
    private Integer score;
}
