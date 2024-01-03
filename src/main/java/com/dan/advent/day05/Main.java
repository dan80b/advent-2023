package com.dan.advent.day05;

import com.dan.advent.common.DocumentReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DocumentReader documentReader = new DocumentReader();
        AlmanacParser parser = new AlmanacParser();

        try {

            List<String> lines = documentReader.readLines("input_day05.txt");
            Almanac almanac = parser.parse(lines);

            System.out.println("Lowest location is: " + almanac.lowestLocation()); //part1: 174137457
            System.out.println("Lowest location for interval is: " + almanac.lowestLocation2()); //part2: 1493866

        } catch (Exception e) {
            System.out.println("Error when processing almanac: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
