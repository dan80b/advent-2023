package com.dan.advent.day04;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        ScratchCardParser parser = new ScratchCardParser();
        PointsCalculator calculator = new PointsCalculator();
        ScratchCardsProcessor processor = new ScratchCardsProcessor();

        try {

            List<String> lines = documentReader.readLines("input_day04.txt");
            List<ScratchCard> cards = parser.parseLines(lines);

            int totalPoints = calculator.calculate(cards);
            System.out.println("There are " + totalPoints + " total points."); //part1: 20107

            List<ScratchCard> processedCars = processor.process(cards);
            int totalCards = processor.totalCards(processedCars);
            System.out.println("There are " + totalCards + " scratch cards."); //part2: 8172507

        } catch (Exception e) {
            System.out.println("Error when calculating points: " + e.getMessage());
        }

    }
}
