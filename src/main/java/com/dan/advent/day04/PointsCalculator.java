package com.dan.advent.day04;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PointsCalculator {

    private final ScratchCardParser parser;

    int calculate(List<String> lines) {
        return lines.stream()
                .map(parser::parse)
                .map(ScratchCard::points)
                .reduce(0, Integer::sum);
    }
}
