package com.dan.advent.day09;

import java.util.List;

public class HistoryService {

    int sumOfNextValues(List<History> histories) {
        return histories.stream()
                .map(History::nextValue)
                .reduce(0, Integer::sum);
    }

    int sumOfPreviousValues(List<History> histories) {
        return histories.stream()
                .map(History::previousValue)
                .reduce(0, Integer::sum);
    }
}
