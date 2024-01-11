package com.dan.advent.day09;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Sequence {

    @Getter
    private final List<Integer> values;

    Sequence nextSequence() {
        return new Sequence(calculateNextSequence());
    }

    private List<Integer> calculateNextSequence() {
        return IntStream.range(1, values.size())
                .mapToObj(this::getValue)
                .toList();
    }

    private int getValue(int i) {
        int previous = values.get(i - 1);
        int current = values.get(i);
        return current - previous;
    }

    boolean isAllZero() {
        return values.stream().noneMatch(e -> e != 0);
    }

    int nextValue(int difference) {
        return lastValue() + difference;
    }

    int lastValue() {
        return values.get(values.size() - 1);
    }
}
