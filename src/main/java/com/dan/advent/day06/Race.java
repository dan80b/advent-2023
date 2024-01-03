package com.dan.advent.day06;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Race {

    private final int time;
    private final int record;

    int winningWays() {
        return (int) IntStream.rangeClosed(1, time)
                .map(this::distance)
                .filter(d -> d > record)
                .count();
    }

    private int distance(int hold) {
        int moveDuration = time - hold;
        return hold * moveDuration;
    }
}
