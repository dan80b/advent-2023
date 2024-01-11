package com.dan.advent.day09;

import java.util.Arrays;
import java.util.List;

public class HistoryParser {

    List<History> parse(List<String> lines) {
        return lines.stream()
                .map(this::parseHistory)
                .toList();
    }

    private History parseHistory(String line) {
        String[] split = line.split(" ");
        List<Integer> values = Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();
        return new History(new Sequence(values));
    }
}
