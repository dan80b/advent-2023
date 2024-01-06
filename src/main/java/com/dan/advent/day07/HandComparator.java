package com.dan.advent.day07;

import java.util.Comparator;

public class HandComparator implements Comparator<Hand> {

    @Override
    public int compare(Hand hand1, Hand hand2) {
        if (hand1.type() != hand2.type()) {
            return hand1.type() - hand2.type();
        } else if (hand1.getCard1().ordinal() != hand2.getCard1().ordinal()) {
            return hand2.getCard1().ordinal() - hand1.getCard1().ordinal();
        } else if (hand1.getCard2().ordinal() != hand2.getCard2().ordinal()) {
            return hand2.getCard2().ordinal() - hand1.getCard2().ordinal();
        } else if (hand1.getCard3().ordinal() != hand2.getCard3().ordinal()) {
            return hand2.getCard3().ordinal() - hand1.getCard3().ordinal();
        } else if (hand1.getCard4().ordinal() != hand2.getCard4().ordinal()) {
            return hand2.getCard4().ordinal() - hand1.getCard4().ordinal();
        } else if (hand1.getCard5().ordinal() != hand2.getCard5().ordinal()) {
            return hand2.getCard5().ordinal() - hand1.getCard5().ordinal();
        }
        return 0;
    }
}


