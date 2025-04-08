package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void shouldCreateValidScoreWhenValueIsWithinRange() {
        Score score = new Score(500);
        assertEquals(500, score.value());
    }

    @Test
    void shouldThrowExceptionWhenValueIsBelowRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Score(-1);
        });
        assertEquals("O Score deve ser um valor entre 0 e 1000", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenValueIsAboveRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Score(1001);
        });
        assertEquals("O Score deve ser um valor entre 0 e 1000", exception.getMessage());
    }

    @Test
    void shouldReturnStringRepresentationWhenToStringIsCalled() {
        Score score = new Score(750);
        assertEquals("750", score.toString());
    }
}