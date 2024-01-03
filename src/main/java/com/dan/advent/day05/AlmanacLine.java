package com.dan.advent.day05;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.Range;

@Getter
@ToString
public class AlmanacLine {

    private final long sourceStart;
    private final long sourceEnd;
    private final long destinationStart;
    private final long destinationEnd;

    private final Range<Long> sourceRange;
    private final Range<Long> destinationRange;

    AlmanacLine(long destinationStart, long sourceStart, long length) {
        this.sourceStart = sourceStart;
        this.sourceEnd = sourceStart + length - 1;
        this.destinationStart = destinationStart;
        this.destinationEnd = destinationStart + length - 1;
        this.sourceRange = Range.of(sourceStart, sourceEnd);
        this.destinationRange = Range.of(destinationStart, destinationEnd);
    }

    long destination(long source) {
        if (containsSource(source)) {
            long diff = source - sourceStart;
            return destinationStart + diff;
        } else {
            throw new IllegalArgumentException("Source not in interval");
        }
    }

    boolean containsSource(long source) {
        return sourceStart <= source && source <= sourceEnd;
    }

    boolean interacts(Range<Long> range) {
        return range.isOverlappedBy(this.sourceRange);
    }

    Range<Long> map(Range<Long> range) {
        if (!sourceRange.isOverlappedBy(range)) {
            throw new IllegalArgumentException("No interacting range");
        } else if (sourceRange.containsRange(range)) {
            return Range.of(range.getMinimum() + difference(), range.getMaximum() + difference());
        } else if (range.containsRange(sourceRange)) {
            return destinationRange;
        } else if (!sourceRange.contains(range.getMinimum()) && sourceRange.contains(range.getMaximum())) {
            return Range.of(destinationStart, range.getMaximum() + difference());
        } else if (sourceRange.contains(range.getMinimum()) && !sourceRange.contains(range.getMaximum())) {
            return Range.of(range.getMinimum() + difference(), destinationEnd);
        } else {
            throw new IllegalArgumentException("No interacting range");
        }
    }

    private long difference() {
        return  destinationRange.getMinimum() - sourceRange.getMinimum();
    }
}
