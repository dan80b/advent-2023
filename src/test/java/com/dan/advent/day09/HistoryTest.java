package com.dan.advent.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class HistoryTest {

    @Test
    void generateSequences() {
        History history = new History(new Sequence(List.of(0, 3, 6, 9, 12, 15)));
        List<Sequence> sequences = history.generateSequences();
        assertEquals(2, sequences.size());
    }

    @Test
    void nextValue() {
        History history = new History(new Sequence(List.of(0, 3, 6, 9, 12, 15)));
        assertEquals(18, history.nextValue());
    }

    @Test
    void nextValue2() {
        History history = new History(new Sequence(List.of(1, 3, 6, 10, 15, 21)));
        assertEquals(28, history.nextValue());
    }

    @Test
    void nextValue3() {
        History history = new History(new Sequence(List.of(10, 13, 16, 21, 30, 45)));
        assertEquals(68, history.nextValue());
    }

    @Test
    void previousValue() {
        History history = new History(new Sequence(List.of(0, 3, 6, 9, 12, 15)));
        assertEquals(-3, history.previousValue());
    }

    @Test
    void previousValue2() {
        History history = new History(new Sequence(List.of(1, 3, 6, 10, 15, 21)));
        assertEquals(0, history.previousValue());
    }

    @Test
    void previousValue3() {
        History history = new History(new Sequence(List.of(10, 13, 16, 21, 30, 45)));
        assertEquals(5, history.previousValue());
    }
}
