package com.dan.advent.day03;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        PartNumberCalculator partNumberCalculator = new PartNumberCalculator();
        PartNumberService partNumberService = new PartNumberService(partNumberCalculator);
        GearCalculator gearCalculator = new GearCalculator();
        GearService gearService = new GearService(gearCalculator);

        try {

            List<String> lines = documentReader.readLines("input_day03.txt");

            int totalSum = partNumberService.sumAllTotalParts(lines);
            System.out.println("Total sum of part numbers is: " + totalSum); //part1: 535351

            int totalGear = gearService.sumTotalGear(lines);
            System.out.println("Total gear is: " + totalGear); //part2: 87287096

        } catch (Exception e) {
            System.out.println("Error when calculating sum of engine schematic: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
