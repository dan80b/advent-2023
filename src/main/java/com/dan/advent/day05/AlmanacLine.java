package com.dan.advent.day05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AlmanacLine {

    private final long destinationStart;
    private final long sourceStart;
    private final long length;

    long destination(long source) {
        if (containsSource(source)) {
            long diff = source - sourceStart;
            return destinationStart + diff;
        } else {
            throw new IllegalArgumentException("Source not in interval");
        }
    }

    boolean containsSource(long source) {
        return sourceStart <= source && source < sourceStart + length;
    }
}
