package com.dan.advent.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LcmCalculatorTest {

    private final LcmCalculator calculator = new LcmCalculator();

    @Test
    void lcm() {
        assertEquals(6, calculator.lcm(List.of(2L, 3L)));
        assertEquals(10_371_555_451_871L, calculator.lcm(List.of(20093L, 12169L, 22357L, 14999L, 13301L, 17263L)));
    }
}
