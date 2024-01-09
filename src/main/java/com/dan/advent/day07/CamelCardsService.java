package com.dan.advent.day07;

import java.util.List;
import java.util.Map;

public class CamelCardsService {

    int calculateWinnings(Map<Hand, Integer> handMap, boolean isJoker) {

        List<Hand> sortedHands = handMap.keySet().stream()
                .sorted(new HandComparator(isJoker))
                .toList();

        int totalWinnings = 0;
        for (int i = 0; i < sortedHands.size(); i++) {
            int rank = i + 1;
            int winnings = rank * handMap.get(sortedHands.get(i));
            totalWinnings = totalWinnings + winnings;
        }

        return totalWinnings;
    }
}
