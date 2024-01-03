package com.dan.advent.day05;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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

    long lowestLocation2() {
        List<Range<Long>> seedsRanges = seedsRanges();
        List<Long> start = new ArrayList<>();
        for (Range<Long> range: seedsRanges) {
            start.add(findLowest(0, range));
        }
        return findMin(start);
    }

    private long findLowest(int i, Range<Long> range) {

        List<AlmanacLine> almanacLines = almanacMaps.get(i).getAlmanacLines();
        List<AlmanacLine> interactingLines = almanacLines.stream()
                .filter(almanacLine -> almanacLine.interacts(range))
                .toList();
        List<Long> start = new ArrayList<>();

        for (AlmanacLine line : interactingLines) {
            Range<Long> output = line.map(range);
            if (i < almanacMaps.size() - 1) {
                start.add(findLowest(i + 1, output));
            } else {
                start.add(output.getMinimum());
            }
        }

        return findMin(start);
    }

    private long findMin(List<Long> array) {
        return array.stream()
                .mapToLong(n -> n)
                .min()
                .orElse(0);
    }

    List<Range<Long>> seedsRanges() {
        AtomicLong counter = new AtomicLong(0);
        return seeds.stream()
                .collect(Collectors.groupingBy(item -> {
                    final long i = counter.getAndIncrement();
                    return (i % 2 ==0) ? i : i - 1;
                })).values()
                .stream()
                .map(a -> Range.of(a.get(0), (a.size() == 2 ? a.get(0) + a.get(1) - 1 : 0)))
                .toList();
    }
}
