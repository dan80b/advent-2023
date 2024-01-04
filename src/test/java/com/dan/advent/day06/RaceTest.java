package com.dan.advent.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void winningWays() {

        Race race1 = new Race(7, 9);
        assertEquals(4, race1.winningWays());

        Race race2 = new Race(15, 40);
        assertEquals(8, race2.winningWays());

        Race race3 = new Race(30, 200);
        assertEquals(9, race3.winningWays());

        Race race4 = new Race(71530L, 940200L);
        assertEquals(71503, race4.winningWays());
    }
}
