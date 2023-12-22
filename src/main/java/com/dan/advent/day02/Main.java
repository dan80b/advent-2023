package com.dan.advent.day02;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        GameParser gameParser = new GameParser();
        GameService service = new GameService(gameParser);

        try {

            List<String> lines = documentReader.readLines("input_day02.txt");

            int sum = service.sumOfPossibleIds(lines);
            System.out.println("Total sum is: " + sum); //part1: 3059

            int totalPower = service.totalPower(lines);
            System.out.println("Total power is: " + totalPower); //part2: 65371

        } catch (Exception e) {
            System.out.println("Error when calculating games data: " + e.getMessage());
        }
    }
}
