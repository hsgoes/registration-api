package com.serasaexperian.registration.api.infrastructure.adapters.entity;

import com.serasaexperian.registration.api.application.domain.entity.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneEntityTest {
    private Phone phone;

    @BeforeEach
    public void setUp() {
        phone = Phone.from("11", "912345678");
    }

    @Test
    public void shouldCreatePhoneEntity_whenConstructorIsCalled() {
        PhoneEntity phoneEntity = new PhoneEntity(phone);

        assertEquals("11", phoneEntity.getDDD());
        assertEquals("912345678", phoneEntity.getNumber());
    }

    @Test
    public void shouldConvertToDomain_whenToDomainIsCalled() {
        PhoneEntity phoneEntity = new PhoneEntity(phone);
        Phone domainPhone = phoneEntity.toDomain();

        assertEquals("11", domainPhone.getDdd().value());
        assertEquals("912345678", domainPhone.getNumber().value());
    }
}
