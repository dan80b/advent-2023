package com.dan.advent.day09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SequenceTest {

    @Test
    void nextSequence() {
        Sequence sequence = new Sequence(List.of(0, 3, 6, 9, 12, 15));
        Sequence nextSequence = sequence.nextSequence();
        assertEquals(5, nextSequence.getValues().size());
        assertEquals(3, nextSequence.getValues().get(0));
    }

    @Test
    void isAllZero() {
        assertFalse(new Sequence(List.of(0, 3, 6, 9, 12, 15)).isAllZero());
        assertTrue(new Sequence(List.of(0, 0, 0, 0)).isAllZero());
    }

    @Test
    void nextValue() {
        Sequence sequence = new Sequence(List.of(0, 3, 6, 9, 12, 15));
        assertEquals(18, sequence.nextValue(3));
    }

    @Test
    void lastValue() {
        Sequence sequence = new Sequence(List.of(0, 3, 6, 9, 12, 15));
        assertEquals(15, sequence.lastValue());
    }

    @Test
    void previousValue() {
        Sequence sequence = new Sequence(List.of(0, 3, 6, 9, 12, 15));
        assertEquals(-3, sequence.previousValue(3));
    }

    @Test
    void firstValue() {
        Sequence sequence = new Sequence(List.of(0, 3, 6, 9, 12, 15));
        assertEquals(0, sequence.firstValue());
    }
}
