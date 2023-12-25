package com.dan.advent.day05;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Almanac {

    private final List<Long> seeds;
    private final List<AlmanacMap> almanacMaps;

    long location(long seed) {
        long destination = 0;
        long source = seed;
        for (AlmanacMap almanacMap : almanacMaps) {
            destination = almanacMap.destination(source);
            source = destination;
        }
        return destination;
    }

    long lowestLocation() {
        return seeds.stream()
                .map(this::location)
                .mapToLong(location -> location)
                .min()
                .orElse(0);
    }

}
