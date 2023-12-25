package com.dan.advent.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlmanacLineTest {

    @Test
    void containsSource() {
        AlmanacLine line = new AlmanacLine(50, 98, 2);
        assertTrue(line.containsSource(98));
        assertTrue(line.containsSource(99));
        assertFalse(line.containsSource(100));
    }

    @Test
    void destination() {
        AlmanacLine line = new AlmanacLine(50, 98, 2);
        assertEquals(50, line.destination(98));
        assertEquals(51, line.destination(99));
        assertThrows(IllegalArgumentException.class, () -> line.destination(100));
    }
}
