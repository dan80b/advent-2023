package com.dan.advent.day07;

import static com.dan.advent.day07.Card.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CamelCardsServiceTest {

    private final CamelCardsService camelCardsService = new CamelCardsService();

    @Test
    void calculateWinnings() {

        Map<Hand, Integer> handsMap = new HashMap<>();
        handsMap.put(new Hand(C3, C2, T, C3, K), 765);
        handsMap.put(new Hand(T, C5, C5, J, C5), 684);
        handsMap.put(new Hand(K, K, C6, C7, C7), 28);
        handsMap.put(new Hand(K, T, J, J, T), 220);
        handsMap.put(new Hand(Q, Q, Q, J, A), 483);

        int winnings = camelCardsService.calculateWinnings(handsMap);
        assertEquals(6440, winnings);
    }
}