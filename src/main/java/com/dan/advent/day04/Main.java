package com.dan.advent.day04;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        PointsCalculator calculator = new PointsCalculator(new ScratchCardParser());

        try {
            List<String> lines = documentReader.readLines("input_day04.txt");
            int totalPoints = calculator.calculate(lines);
            System.out.println("There are " + totalPoints + " total points."); //part1: 20107
        } catch (Exception e) {
            System.out.println("Error when calculating points: " + e.getMessage());
        }

    }
}
