package com.dan.advent.day07;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;

@RequiredArgsConstructor
public class HandComparator implements Comparator<Hand> {

    private final boolean isJoker;

    @Override
    public int compare(Hand hand1, Hand hand2) {

        Hand comparingHand1 = isJoker ? hand1.transformed() : hand1;
        Hand comparingHand2 = isJoker ? hand2.transformed() : hand2;

        if (comparingHand1.type() != comparingHand2.type()) {
            return comparingHand1.type() - comparingHand2.type();
        } else if (hand1.getCard1().getRank(isJoker) != hand2.getCard1().getRank(isJoker)) {
            return hand2.getCard1().getRank(isJoker) - hand1.getCard1().getRank(isJoker);
        } else if (hand1.getCard2().getRank(isJoker) != hand2.getCard2().getRank(isJoker)) {
            return hand2.getCard2().getRank(isJoker) - hand1.getCard2().getRank(isJoker);
        } else if (hand1.getCard3().getRank(isJoker) != hand2.getCard3().getRank(isJoker)) {
            return hand2.getCard3().getRank(isJoker) - hand1.getCard3().getRank(isJoker);
        } else if (hand1.getCard4().getRank(isJoker) != hand2.getCard4().getRank(isJoker)) {
            return hand2.getCard4().getRank(isJoker) - hand1.getCard4().getRank(isJoker);
        } else if (hand1.getCard5().getRank(isJoker) != hand2.getCard5().getRank(isJoker)) {
            return hand2.getCard5().getRank(isJoker) - hand1.getCard5().getRank(isJoker);
        }
        return 0;
    }
}


