package com.serasaexperian.registration.api.application.domain.valueclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DDDTest {

    @Test
    void shouldCreateDDD_WhenValueIsValid() {
        var ddd = new DDD("11");

        assertEquals("11", ddd.toString());
    }

//    @Test
//    void shouldReturnEmptyString_WhenValueIsEmpty() {
//        var ddd = new DDD("");
//
//        assertEquals("", ddd.toString());
//    }

//    @Test
//    void shouldThrowException_WhenValueIsInvalid() {
//        assertThrows(new DDD(null))
//
//        var ddd = new DDD(null);
//    }
}