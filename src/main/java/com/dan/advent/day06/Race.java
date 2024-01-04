package com.dan.advent.day06;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

@RequiredArgsConstructor
public class Race {

    private final long time;
    private final long record;

    int winningWays() {
        return (int) LongStream.rangeClosed(1, time)
                .map(this::distance)
                .filter(d -> d > record)
                .count();
    }

    private long distance(long hold) {
        long moveDuration = time - hold;
        return hold * moveDuration;
    }
}
