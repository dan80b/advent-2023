package com.dan.advent.day05;

import org.apache.commons.lang3.Range;
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

    @Test
    void map() {
        //50 - 97 -> 52 - 99
        AlmanacLine line = new AlmanacLine(52, 50, 48);

        assertThrows(IllegalArgumentException.class, () -> line.map(Range.of(10L, 11L)));
        assertThrows(IllegalArgumentException.class, () -> line.map(Range.of(100L, 110L)));

        Range<Long> range1 = line.map(Range.of(60L, 80L));
        assertEquals(62, range1.getMinimum());
        assertEquals(82, range1.getMaximum());

        Range<Long> range2 = line.map(Range.of(40L, 99L));
        assertEquals(52, range2.getMinimum());
        assertEquals(99, range2.getMaximum());

        Range<Long> range3 = line.map(Range.of(40L, 60L));
        assertEquals(52, range3.getMinimum());
        assertEquals(62, range3.getMaximum());

        Range<Long> range4 = line.map(Range.of(60L, 100L));
        assertEquals(62, range4.getMinimum());
        assertEquals(99, range4.getMaximum());
    }
}
