package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    void shouldCreateValidStateWhenValueIsProvided() {
        State state = new State("SP");
        assertEquals("SP", state.value());
    }

    @Test
    void shouldReturnStringRepresentationWhenToStringIsCalled() {
        State state = new State("RJ");
        assertEquals("RJ", state.toString());
    }
}