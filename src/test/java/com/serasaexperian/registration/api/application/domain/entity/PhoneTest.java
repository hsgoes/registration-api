package com.serasaexperian.registration.api.application.domain.entity;

import com.serasaexperian.registration.api.application.domain.valueclass.DDD;
import com.serasaexperian.registration.api.application.domain.valueclass.PhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PhoneTest {

    @Test
    public void shouldCreatePhone_whenCreateIsCalled() {
        Phone phone = Phone.create(
                new DDD("11"),
                new PhoneNumber("912345678")
        );

        assertNotNull(phone);
        assertEquals("11", phone.getDdd().value());
        assertEquals("912345678", phone.getNumber().value());
    }

    @Test
    public void shouldCreatePhone_whenFromIsCalled() {
        Phone phone = Phone.from("11", "912345678");

        assertNotNull(phone);
        assertEquals("11", phone.getDdd().value());
        assertEquals("912345678", phone.getNumber().value());
    }
}