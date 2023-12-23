package com.dan.advent.day04;

import java.util.Arrays;
import java.util.List;

public class ScratchCardParser {

    List<ScratchCard> parseLines(List<String> lines) {
        return lines.stream()
                .map(this::parse)
                .toList();
    }

    ScratchCard parse(String line) {

        String numbers = line.split(":")[1].trim();
        String winningNumbersString = numbers.split("\\|")[0].trim();
        String ownNumbersString = numbers.split("\\|")[1].trim();

        List<Integer> winningNumbers = parseNumbers(winningNumbersString);
        List<Integer> ownNumbers = parseNumbers(ownNumbersString);

        return new ScratchCard(winningNumbers, ownNumbers);
    }

    private List<Integer> parseNumbers(String numbersString) {
        List<String> numbers = Arrays.asList(numbersString.split(" "));
        return numbers.stream()
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }
}
