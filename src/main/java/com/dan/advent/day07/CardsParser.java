package com.dan.advent.day07;

import static com.dan.advent.day07.Card.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardsParser {

    private static final Map<Character, Card> CARDS = new HashMap<>();

    static {
        CARDS.put('A', A);
        CARDS.put('K', K);
        CARDS.put('Q', Q);
        CARDS.put('J', J);
        CARDS.put('T', T);
        CARDS.put('9', C9);
        CARDS.put('8', C8);
        CARDS.put('7', C7);
        CARDS.put('6', C6);
        CARDS.put('5', C5);
        CARDS.put('4', C4);
        CARDS.put('3', C3);
        CARDS.put('2', C2);
    }

    Map<Hand, Integer> parse(List<String> lines) {
        Map<Hand, Integer> handsMap = new HashMap<>();
        for (String line : lines) {
            String[] split = line.split(" ");
            String cards = split[0];
            String bid = split[1];
            handsMap.put(parseCards(cards), Integer.parseInt(bid));
        }
        return handsMap;
    }

    Hand parseCards(String input) {
        return new Hand(card(input, 0), card(input, 1), card(input, 2), card(input, 3), card(input, 4));
    }

    Card card(String input, int index) {
        return CARDS.get(input.charAt(index));
    }
}
