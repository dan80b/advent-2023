package com.dan.advent.day07;

import static com.dan.advent.day07.Card.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HandTransformerTest {

    private final HandTransformer handTransformer = new HandTransformer();

    @Test
    void transform() {
        Hand hand = new Hand(T, C5, C5, J, T);
        Hand transformed = handTransformer.transform(hand);
        assertEquals(T, transformed.getCard4());
    }
}
