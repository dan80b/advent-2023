package com.dan.advent.day07;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Hand {

    private final Card card1;
    private final Card card2;
    private final Card card3;
    private final Card card4;
    private final Card card5;

    private final Map<Card, Integer> cardsMap = new HashMap<>();
    private int maxOfType;

    Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.card4 = card4;
        this.card5 = card5;
        initCards();
    }

    private void initCards() {
        List<Card> cards = List.of(card1, card2, card3, card4, card5);
        for (Card card : cards) {
            cardsMap.merge(card, 1, Integer::sum);
        }
        maxOfType = cardsMap.values().stream()
                .reduce(0, Integer::max);
    }

    Hand replaceJokerWith(Card card) {
        Card newCard1 = replaceIfJoker(card1, card);
        Card newCard2 = replaceIfJoker(card2, card);
        Card newCard3 = replaceIfJoker(card3, card);
        Card newCard4 = replaceIfJoker(card4, card);
        Card newCard5 = replaceIfJoker(card5, card);
        return new Hand(newCard1, newCard2, newCard3, newCard4, newCard5);
    }

    private Card replaceIfJoker(Card oldCard, Card newCard) {
        return oldCard == Card.J ? newCard : oldCard;
    }

    boolean isFive() {
        return maxOfType == 5;
    }

    boolean isFour() {
        return maxOfType == 4;
    }

    boolean isFullHouse() {
        return maxOfType == 3 && hasPair();
    }

    boolean isThree() {
        return maxOfType == 3 && !hasPair();
    }

    private boolean hasPair() {
        return cardsMap.values().stream().anyMatch(v -> v == 2);
    }

    boolean isTwoPair() {
        return countPairs() == 2;
    }

    boolean isOnePair() {
        return countPairs() == 1 && countSingle() == 3;
    }

    boolean isHighCard() {
        return countSingle() == 5;
    }

    private long countPairs() {
        return cardsMap.values().stream()
                .filter(v -> v == 2)
                .count();
    }

    private long countSingle() {
        return cardsMap.values().stream()
                .filter(v -> v == 1)
                .count();
    }

    int type() {
        if (isFive()) {
            return 7;
        } else if (isFour()) {
            return 6;
        } else if (isFullHouse()) {
            return 5;
        } else if (isThree()) {
            return 4;
        } else if (isTwoPair()) {
            return 3;
        } else if (isOnePair()) {
            return 2;
        } else if (isHighCard()) {
            return 1;
        } else {
            return 0;
        }
    }

    Hand transformed() {
        return new HandTransformer().transform(this);
    }
}
