package com.dan.advent.day07;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class HandTransformer {

    Hand transform(Hand hand) {

        try {
            Map<Card, Integer> removeJoker = removeJoker(hand);

            if (removeJoker.isEmpty()) {
                return hand;
            }

            final int max = removeJoker.values().stream().max(Comparator.naturalOrder()).get();
            Card biggestCard = biggestCard(removeJoker, max);
            return hand.replaceJokerWith(biggestCard);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<Card, Integer> removeJoker(Hand hand) {
        return hand.getCardsMap().entrySet().stream()
                .filter(e -> e.getKey() != Card.J)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Card biggestCard(Map<Card, Integer> removeJoker, int max) {
        return removeJoker.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .toList()
                .stream()
                .sorted()
                .findFirst()
                .get();
    }
}
