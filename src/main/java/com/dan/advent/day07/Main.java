package com.dan.advent.day07;

import com.dan.advent.common.DocumentReader;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        CardsParser parser = new CardsParser();
        CamelCardsService service = new CamelCardsService();

        try {

            List<String> lines = documentReader.readLines("input_day07.txt");
            Map<Hand, Integer> hands = parser.parse(lines);

            int winnings = service.calculateWinnings(hands, false);
            System.out.println("Total winnings are: " + winnings); //part1: 251121738

            int winningsWithJoker = service.calculateWinnings(hands, true);
            System.out.println("Total winnings are: " + winningsWithJoker); //part1: 251421071

        } catch (Exception e) {
            System.out.println("Error when processing cards: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
