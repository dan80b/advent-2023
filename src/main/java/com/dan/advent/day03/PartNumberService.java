package com.dan.advent.day03;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PartNumberService {

    private final PartNumberCalculator partNumberCalculator;

    int sumAllTotalParts(List<String> lines) {
        int totalSum = 0;
        for (int i = 0; i < lines.size(); i++) {
            int sum = sumPartNumbers(lines, i);
            totalSum = totalSum + sum;
        }
        return totalSum;
    }

    private int sumPartNumbers(List<String> lines, int i) {
        int lastIndex = lines.size() - 1;
        if (i == 0) {
            return partNumberCalculator.sumPartNumbers(lines.get(0), null, lines.get(1));
        } else if (i == lastIndex) {
            return partNumberCalculator.sumPartNumbers(lines.get(lines.size() - 1), lines.get(lines.size() - 2), null);
        } else {
            return partNumberCalculator.sumPartNumbers(lines.get(i), lines.get(i - 1), lines.get(i + 1));
        }
    }
}
