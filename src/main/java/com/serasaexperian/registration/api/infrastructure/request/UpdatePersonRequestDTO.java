package com.serasaexperian.registration.api.infrastructure.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePersonRequestDTO {
    @Schema(description = "Nome da pessoa")
    private String name;
    @Schema(description = "Idade da pessoa")
    private String age;
    @Schema(description = "Cep da residencia", example = "12345678")
    @NotNull(message = "O cep não pode ser vazio")
    private String zipCode;
    @Schema(description = "Número do documento da pessoa")
    private String number;
    @Schema(description = "Tipo do documento da pessoa")
    private Integer score;
    @Schema(description = "DDD do telefone da pessoa")
    private String ddd;
    @Schema(description = "Número do telefone da pessoa")
    private String phoneNumber;
}
