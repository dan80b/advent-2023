package com.dan.advent.day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScratchCardTest {

    @Test
    void scratchCard1() {
        ScratchCard card = new ScratchCard(
                List.of(41, 48, 83, 86, 17),
                List.of(83, 86, 6, 31, 17, 9, 48, 53)
        );
        assertEquals(4, card.matches());
        assertEquals(8, card.points());
    }

    @Test
    void scratchCard2() {
        ScratchCard card = new ScratchCard(
                List.of(13, 32, 20, 16, 61),
                List.of(61, 30, 68, 82, 17, 32, 24, 19)
        );
        assertEquals(2, card.matches());
        assertEquals(2, card.points());
    }

    @Test
    void scratchCard3() {
        ScratchCard card = new ScratchCard(
                List.of(1, 21, 53, 59, 44),
                List.of(69, 82, 68, 63, 72, 21, 14, 1)
        );
        assertEquals(2, card.matches());
        assertEquals(2, card.points());
    }

    @Test
    void scratchCard4() {
        ScratchCard card = new ScratchCard(
                List.of(41, 92, 73, 84, 69),
                List.of(59, 84, 76, 51, 58, 54, 83)
        );
        assertEquals(1, card.matches());
        assertEquals(1, card.points());
    }

    @Test
    void scratchCard5() {
        ScratchCard card = new ScratchCard(
                List.of(87, 83, 26, 28, 32),
                List.of(88, 30, 70, 12, 93, 22, 82, 36)
        );
        assertEquals(0, card.matches());
        assertEquals(0, card.points());
    }

    @Test
    void scratchCard6() {
        ScratchCard card = new ScratchCard(
                List.of(31, 18, 13, 56, 72),
                List.of(74, 77, 10, 23, 35, 67, 36, 11)
        );
        assertEquals(0, card.matches());
        assertEquals(0, card.points());
    }
}
