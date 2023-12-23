package com.dan.advent.day04;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ScratchCard {

    private final List<Integer> winningNumbers;
    private final List<Integer> ownNumbers;

    @Getter
    private int count = 1;

    int matches() {
        return winningNumbers.stream()
            .distinct()
            .filter(ownNumbers::contains)
            .collect(Collectors.toSet()).size();
    }

    int points() {
        int matches = matches();
        if (matches == 0) {
            return 0;
        } else {
            return (int) Math.pow(2, matches - 1);
        }
    }

    void increaseCount(int amount) {
        count += amount;
    }
}
