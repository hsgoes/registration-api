package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipCodeTest {

    @Test
    void shouldCreateZipCode_WhenValueIsValid() {
        var zipCode = new ZipCode("12345-678");

        assertEquals("12345-678", zipCode.toString());
    }

    @Test
    void shouldReturnEmptyString_WhenValueIsEmpty() {
        var zipCode = new ZipCode("");

        assertEquals("", zipCode.toString());
    }

    @Test
    void shouldReturnNull_WhenValueIsNull() {
        var zipCode = new ZipCode(null);

        assertEquals(null, zipCode.toString());
    }
}