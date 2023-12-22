package com.dan.advent.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Calibrator {

    private static final Map<String, Character> DIGITS_MAP = Map.of(
            "one", '1',
            "two", '2',
            "three", '3',
            "four", '4',
            "five", '5',
            "six", '6',
            "seven", '7',
            "eight", '8',
            "nine", '9'
    );

    int calibrate(List<String> lines) {
        return lines.stream()
                .map(this::calibrate)
                .reduce(0, Integer::sum);
    }

    int calibrate(String line) {
        List<Character> digits = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            for (String digit : DIGITS_MAP.keySet()) {
                if (line.substring(i).startsWith(digit)) {
                    digits.add(DIGITS_MAP.get(digit));
                }
            }
            if (Character.isDigit(c)) {
                digits.add(c);
            }
        }
        String value = digits.get(0) + String.valueOf(digits.get(digits.size() - 1));
        return Integer.parseInt(value);
    }

}
