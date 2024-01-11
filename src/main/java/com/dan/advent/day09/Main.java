package com.dan.advent.day09;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        HistoryParser parser = new HistoryParser();
        HistoryService service = new HistoryService();

        try {

            List<String> lines = documentReader.readLines("input_day09.txt");
            List<History> histories = parser.parse(lines);

            int sumOfNextValues = service.sumOfNextValues(histories);
            System.out.println("Total sum of next extrapolated values is: " + sumOfNextValues); //part1: 1696140818

            int sumOfPreviousValues = service.sumOfPreviousValues(histories);
            System.out.println("Total sum of previous extrapolated values is: " + sumOfPreviousValues); //part2: 1152

        } catch (Exception e) {
            System.out.println("Error calculating sum: " + e.getMessage());
        }
    }
}
