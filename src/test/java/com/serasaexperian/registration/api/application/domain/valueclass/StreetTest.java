package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    @Test
    void shouldCreateValidStreetWhenValueIsProvided() {
        Street street = new Street("Avenida Paulista");
        assertEquals("Avenida Paulista", street.value());
    }

    @Test
    void shouldReturnStringRepresentationWhenToStringIsCalled() {
        Street street = new Street("Rua XV de Novembro");
        assertEquals("Rua XV de Novembro", street.toString());
    }
}