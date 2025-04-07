package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NameTest {

    @Test
    void shouldCreateName_WhenValueIsValid() {
        var name = new Name("Joao Silva");

        assertEquals("Joao Silva", name.toString());
    }

    @Test
    void shouldReturnEmptyString_WhenValueIsEmpty() {
        var name = new Name("");

        assertEquals("", name.toString());
    }

    @Test
    void shouldReturnNull_WhenValueIsNull() {
        var name = new Name(null);

        assertNull(name.toString());
    }
}