package com.dan.advent.day04;

import java.util.List;

public class ScratchCardsProcessor {

    List<ScratchCard> process(List<ScratchCard> cards) {
        for (int i = 0; i < cards.size(); i++) {
            ScratchCard card = cards.get(i);
            int matches = card.matches();
            for (int j = i + 1; j <= i + matches; j++) {
                ScratchCard nextCard = cards.get(j);
                nextCard.increaseCount(card.getCount());
            }
        }
        return cards;
    }

    int totalCards(List<ScratchCard> cards) {
        return cards.stream()
                .map(ScratchCard::getCount)
                .reduce(0,Integer::sum);
    }
}
