package com.serasaexperian.registration.api.infrastructure.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePersonRequestDTO {
    private String name;
    private String age;
    private String zipCode;
    private String number;
    private Integer score;
    private String ddd;
    private String phoneNumber;
}
