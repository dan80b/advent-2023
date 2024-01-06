package com.dan.advent.day07;

import static com.dan.advent.day07.Card.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HandComparatorTest {

    private final HandComparator handComparator = new HandComparator();

    @Test
    void compare1() {
        Hand hand1 = new Hand(C3, C3, C3, C3, C2);
        Hand hand2 = new Hand(C2, A, A, A, A);
        assertTrue(handComparator.compare(hand1, hand2) > 0);
    }

    @Test
    void compare2() {
        Hand hand1 = new Hand(C7, C7, C8, C8, C8);
        Hand hand2 = new Hand(C7, C7, C7, C8, C8);
        assertTrue(handComparator.compare(hand1, hand2) > 0);
    }

    @Test
    void compare3() {
        Hand hand1 = new Hand(C3, C2, T, C3, K);
        Hand hand2 = new Hand(K, K, C6, C7, C7);
        assertTrue(handComparator.compare(hand1, hand2) < 0);
    }

    @Test
    void compare4() {
        Hand hand1 = new Hand(K, T, J, J, T);
        Hand hand2 = new Hand(Q, Q, Q, J, A);
        assertTrue(handComparator.compare(hand1, hand2) < 0);
    }
}
