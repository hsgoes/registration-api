package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    void shouldCreatePhoneNumber_WhenValueIsValid() {
        var phoneNumber = new PhoneNumber("123-456-7890");

        assertEquals("123-456-7890", phoneNumber.toString());
    }

    @Test
    void shouldReturnEmptyString_WhenValueIsEmpty() {
        var phoneNumber = new PhoneNumber("");

        assertEquals("", phoneNumber.toString());
    }

    @Test
    void shouldReturnNull_WhenValueIsNull() {
        var phoneNumber = new PhoneNumber(null);

        assertNull(phoneNumber.toString());
    }
}