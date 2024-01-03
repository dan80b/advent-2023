package com.dan.advent.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RaceParser {

    List<Race> parse(List<String> lines) {

        List<Race> races = new ArrayList<>();

        List<Integer> times = null;
        List<Integer> distances = null;

        for (String line : lines) {
            if (line.startsWith("Time:")) {
                times = parseValues(line);
            } else if (line.startsWith("Distance:")) {
                distances = parseValues(line);
            }

        }

        if (times == null || distances == null) {
            return Collections.emptyList();
        }

        for (int i = 0; i < times.size(); i++) {
            races.add(new Race(times.get(i), distances.get(i)));
        }

        return races;
    }

    List<Integer> parseValues(String line) {
        String valuesString = line.substring(10);
        return Arrays.stream(valuesString.split(" "))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }
}
