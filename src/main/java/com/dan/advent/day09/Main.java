package com.dan.advent.day09;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        HistoryParser parser = new HistoryParser();

        try {

            List<String> lines = documentReader.readLines("input_day09.txt");
            List<History> histories = parser.parse(lines);
            int sum = histories.stream()
                    .map(History::nextValue)
                    .reduce(0, Integer::sum);

            System.out.println("Total sum of extrapolated values is: " + sum); //part1: 1696140818

        } catch (Exception e) {
            System.out.println("Error calculating sum: " + e.getMessage());
        }
    }
}
