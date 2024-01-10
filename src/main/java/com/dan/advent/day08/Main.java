package com.dan.advent.day08;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        NetworkParser parser = new NetworkParser();
        NetworkNavigator networkNavigator = new NetworkNavigator();

        try {

            List<String> lines = documentReader.readLines("input_day08.txt");
            Network network = parser.parse(lines);
            int steps = networkNavigator.countSteps(network);
            System.out.println("The number of steps is: " + steps); //part1: 22357

        } catch (Exception e) {
            System.out.println("Error when finding path: " + e.getMessage());
        }
    }
}
