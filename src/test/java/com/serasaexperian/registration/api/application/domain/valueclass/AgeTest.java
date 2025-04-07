package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AgeTest {

    @Test
    void shouldCreateAge_WhenValueIsValid() {
        var age = new Age("30");

        assertEquals("30", age.toString());
    }

    @Test
    void shouldReturnEmptyString_WhenValueIsEmpty() {
        var age = new Age("");

        assertEquals("", age.toString());
    }

    @Test
    void shouldReturnNull_WhenValueIsNull() {
        var age = new Age(null);

        assertNull(age.toString());
    }
}