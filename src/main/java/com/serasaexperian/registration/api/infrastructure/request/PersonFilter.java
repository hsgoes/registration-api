package com.serasaexperian.registration.api.infrastructure.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonFilter {
    private String name;
    private String age;
    private String zipCode;
}
