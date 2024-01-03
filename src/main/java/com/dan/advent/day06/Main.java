package com.dan.advent.day06;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        RaceParser parser = new RaceParser();

        try {

            List<String> lines = documentReader.readLines("input_day06.txt");
            List<Race> races = parser.parse(lines);

            int totalWays = races.stream()
                    .map(Race::winningWays)
                    .reduce(1, (a, b) -> a * b);

            System.out.println("Total wining was are : " + totalWays); //part 1: 316800

        } catch (Exception e) {
            System.out.println("Error when processing races: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
