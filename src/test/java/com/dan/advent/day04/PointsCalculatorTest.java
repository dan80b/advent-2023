package com.dan.advent.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointsCalculatorTest {

    private final PointsCalculator pointsCalculator = new PointsCalculator();

    @Test
    void calculate() {
        assertEquals(13, pointsCalculator.calculate(TestInput.inputCards()));
    }
}
