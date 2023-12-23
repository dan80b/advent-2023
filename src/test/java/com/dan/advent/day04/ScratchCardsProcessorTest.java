package com.dan.advent.day04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ScratchCardsProcessorTest {

    private final ScratchCardParser parser = new ScratchCardParser();
    private final ScratchCardsProcessor process = new ScratchCardsProcessor();

    @Test
    void process() {

        List<ScratchCard> processedCards = process.process(TestInput.inputCards());

        assertEquals(1,processedCards.get(0).getCount());
        assertEquals(2,processedCards.get(1).getCount());
        assertEquals(4,processedCards.get(2).getCount());
        assertEquals(8,processedCards.get(3).getCount());
        assertEquals(14,processedCards.get(4).getCount());
        assertEquals(1,processedCards.get(5).getCount());

        assertEquals(30, process.totalCards(processedCards));
    }
}
