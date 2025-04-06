package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.DDD;
import com.serasaexperian.registration.api.application.domain.valueclass.PhoneNumber;
import lombok.Getter;

@Getter
public class Phone {
    private final DDD ddd;
    private final PhoneNumber number;

    private Phone(DDD ddd, PhoneNumber number) {
        this.ddd = ddd;
        this.number = number;
    }

    public static Phone create(DDD ddd, PhoneNumber number) {
        return new Phone(ddd, number);
    }

    public static Phone from(String ddd, String number) {
        return new Phone(
                new DDD(ddd),
                new PhoneNumber(number)
        );
    }
}
