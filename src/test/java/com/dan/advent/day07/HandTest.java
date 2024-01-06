package com.dan.advent.day07;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HandTest {

    @Test
    void isFive() {
        Hand hand = new Hand(Card.A, Card.A, Card.A, Card.A, Card.A);
        assertTrue(hand.isFive());
    }

    @Test
    void isNotFive() {
        Hand hand = new Hand(Card.A, Card.A, Card.A, Card.A, Card.Q);
        assertFalse(hand.isFive());
    }

    @Test
    void isFour() {

        Hand hand1 = new Hand(Card.A, Card.A, Card.A, Card.A, Card.Q);
        assertTrue(hand1.isFour());

        Hand hand2 = new Hand(Card.A, Card.Q, Card.A, Card.A, Card.A);
        assertTrue(hand2.isFour());

        Hand hand3 = new Hand(Card.A, Card.A, Card.Q, Card.A, Card.A);
        assertTrue(hand3.isFour());
    }

    @Test
    void isNotFour() {
        Hand hand = new Hand(Card.A, Card.A, Card.C2, Card.A, Card.Q);
        assertFalse(hand.isFour());
    }

    @Test
    void isFullHouse() {

        Hand hand1 = new Hand(Card.A, Card.A, Card.A, Card.Q, Card.Q);
        assertTrue(hand1.isFullHouse());

        Hand hand2 = new Hand(Card.Q, Card.Q, Card.A, Card.A, Card.Q);
        assertTrue(hand2.isFullHouse());
    }

    @Test
    void isNotFullHouse() {
        Hand hand = new Hand(Card.A, Card.A, Card.C2, Card.A, Card.Q);
        assertFalse(hand.isFullHouse());
    }

    @Test
    void isThree() {

        Hand hand1 = new Hand(Card.A, Card.A, Card.A, Card.Q, Card.J);
        assertTrue(hand1.isThree());

        Hand hand2 = new Hand(Card.Q, Card.Q, Card.A, Card.J, Card.Q);
        assertTrue(hand2.isThree());
    }

    @Test
    void isNotThree() {
        Hand hand = new Hand(Card.A, Card.A, Card.C2, Card.C7, Card.Q);
        assertFalse(hand.isThree());
    }

    @Test
    void isTwoPair() {

        Hand hand1 = new Hand(Card.A, Card.Q, Card.Q, Card.J, Card.A);
        assertTrue(hand1.isTwoPair());

        Hand hand2 = new Hand(Card.A, Card.C9, Card.A, Card.C2, Card.C2);
        assertTrue(hand2.isTwoPair());
    }

    @Test
    void isNotTwoPair() {
        Hand hand = new Hand(Card.A, Card.A, Card.C2, Card.C7, Card.Q);
        assertFalse(hand.isTwoPair());
    }

    @Test
    void isOnePair() {

        Hand hand1 = new Hand(Card.A, Card.C7, Card.Q, Card.J, Card.A);
        assertTrue(hand1.isOnePair());

        Hand hand2 = new Hand(Card.Q, Card.C9, Card.A, Card.C2, Card.C2);
        assertTrue(hand2.isOnePair());
    }

    @Test
    void isHighCard() {
        Hand hand = new Hand(Card.A, Card.J, Card.C2, Card.C7, Card.Q);
        assertTrue(hand.isHighCard());
    }
}
