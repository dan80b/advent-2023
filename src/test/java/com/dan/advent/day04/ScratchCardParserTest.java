package com.dan.advent.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScratchCardParserTest {

    private final ScratchCardParser parser = new ScratchCardParser();

    @Test
    void parse1() {
        String line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        ScratchCard card = parser.parse(line);
        assertEquals(4, card.matches());
        assertEquals(8, card.points());
    }

    @Test
    void parse2() {
        String line = "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19";
        ScratchCard card = parser.parse(line);
        assertEquals(2, card.matches());
        assertEquals(2, card.points());
    }
    @Test
    void parse3() {
        String line = "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1";
        ScratchCard card = parser.parse(line);
        assertEquals(2, card.matches());
        assertEquals(2, card.points());
    }

    @Test
    void parse4() {
        String line = "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83";
        ScratchCard card = parser.parse(line);
        assertEquals(1, card.matches());
        assertEquals(1, card.points());
    }

    @Test
    void parse5() {
        String line = "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36";
        ScratchCard card = parser.parse(line);
        assertEquals(0, card.matches());
        assertEquals(0, card.points());
    }

    @Test
    void parse6() {
        String line = "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11";
        ScratchCard card = parser.parse(line);
        assertEquals(0, card.matches());
        assertEquals(0, card.points());
    }
}
