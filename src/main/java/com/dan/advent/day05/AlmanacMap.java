package com.dan.advent.day05;

import java.util.List;

public class AlmanacMap {

    private final List<AlmanacLine> almanacLines;

    AlmanacMap(List<AlmanacLine> almanacLines) {
        this.almanacLines = almanacLines;
    }

    long destination(long source) {
        return almanacLines.stream()
                .filter(line -> line.containsSource(source))
                .findFirst()
                .map(almanacLine -> almanacLine.destination(source))
                .orElse(source);
    }
}
