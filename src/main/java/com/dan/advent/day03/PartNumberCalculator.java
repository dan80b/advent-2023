package com.dan.advent.day03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartNumberCalculator {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");

    int sumPartNumbers(String line, String previousLine, String nextLine) {

        int total = 0;
        Matcher matcher = INTEGER_PATTERN.matcher(line);

        while (matcher.find()) {
            PartNumberVerifier verifier = new PartNumberVerifier(matcher.start(), matcher.group());
            if (verifier.verify(line, previousLine, nextLine)) {
                total += Integer.parseInt(verifier.getNumber());
            }
        }

        return total;
    }
}
