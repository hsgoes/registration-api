package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CityTest {

    @Test
    void shouldCreateCity_WhenValueIsValid() {
        var city = new City("São Paulo");

        assertEquals("São Paulo", city.toString());
    }

    @Test
    void shouldReturnEmptyString_WhenValueIsEmpty() {
        var city = new City("");

        assertEquals("", city.toString());
    }

    @Test
    void shouldReturnNull_WhenValueIsNull() {
        var city = new City(null);

        assertNull(city.toString());
    }
}