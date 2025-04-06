package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.DDD;
import com.serasaexperian.registration.api.application.domain.valueclass.Number;
import lombok.Getter;

@Getter
public class Phone {
    private final DDD ddd;
    private final Number number;

    private Phone(DDD ddd, Number number) {
        this.ddd = ddd;
        this.number = number;
    }

    public static Phone create(DDD ddd, Number number) {
        return new Phone(ddd, number);
    }

    public static Phone from(String ddd, String number) {
        return new Phone(
                new DDD(ddd),
                new Number(number)
        );
    }
}
