package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StreetNumberTest {

    @Test
    void shouldCreateValidStreetNumberWhenValueIsProvided() {
        StreetNumber streetNumber = new StreetNumber("123");
        assertEquals("123", streetNumber.value());
    }

    @Test
    void shouldReturnStringRepresentationWhenToStringIsCalled() {
        StreetNumber streetNumber = new StreetNumber("456");
        assertEquals("456", streetNumber.toString());
    }
}