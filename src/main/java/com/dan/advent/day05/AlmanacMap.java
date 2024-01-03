package com.dan.advent.day05;

import lombok.Getter;
import org.apache.commons.lang3.Range;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlmanacMap {

    private static final Long MAX_NUMBER =  5_000_000_000L; //100L;

    @Getter
    private final List<AlmanacLine> almanacLines;

    AlmanacMap(List<AlmanacLine> almanacLines) {
        almanacLines = sortedLines(almanacLines);
        this.almanacLines = initLines(almanacLines);
    }

    long destination(long source) {
        return almanacLines.stream()
                .filter(line -> line.containsSource(source))
                .findFirst()
                .map(almanacLine -> almanacLine.destination(source))
                .orElse(source);
    }

    private List<AlmanacLine> sortedLines(List<AlmanacLine> lines) {
        return lines.stream()
                .sorted(Comparator.comparingLong(line -> line.getSourceRange().getMinimum()))
                .toList();
    }

    private List<AlmanacLine> initLines(List<AlmanacLine> almanacLines) {

        List<AlmanacLine> lines = new ArrayList<>(almanacLines);
        long nextStart = 0;

        for (AlmanacLine line : almanacLines) {
            Range<Long> sourceRange = line.getSourceRange();
            if (sourceRange.getMinimum() > nextStart) {
                long end = sourceRange.getMinimum() - 1;
                lines.add(new AlmanacLine(nextStart, nextStart, end - nextStart));
            }
            nextStart = sourceRange.getMaximum() + 1 ;
        }

        if (nextStart < MAX_NUMBER) {
            lines.add(new AlmanacLine(nextStart, nextStart, MAX_NUMBER - 1 - nextStart));
        }

        return sortedLines(lines);
    }
}
