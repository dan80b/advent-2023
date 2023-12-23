package com.dan.advent.day04;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PointsCalculator {

    int calculate(List<ScratchCard> cards) {
        return cards.stream()
                .map(ScratchCard::points)
                .reduce(0, Integer::sum);
    }
}
