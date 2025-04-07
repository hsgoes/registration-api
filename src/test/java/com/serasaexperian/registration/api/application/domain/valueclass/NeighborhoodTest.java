package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighborhoodTest {

    @Test
    void shouldCreateNeighborhood_WhenValueIsValid() {
        var neighborhood = new Neighborhood("Centro");

        assertEquals("Centro", neighborhood.toString());
    }

    @Test
    void shouldReturnEmptyString_WhenValueIsEmpty() {
        var neighborhood = new Neighborhood("");

        assertEquals("", neighborhood.toString());
    }

    @Test
    void shouldReturnNull_WhenValueIsNull() {
        var neighborhood = new Neighborhood(null);

        assertNull(neighborhood.toString());
    }
}