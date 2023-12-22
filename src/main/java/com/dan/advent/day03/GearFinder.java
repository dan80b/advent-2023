package com.dan.advent.day03;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GearFinder {

    private final int currentLineIndex;
    private final int startIndex;
    private final int endIndex;

    @Getter
    private final String number;

    GearFinder(int currentLineIndex, int startIndex, String number) {

        if (number.startsWith("-")) {
            number = number.substring(1);
            startIndex = startIndex + 1;
        }

        this.startIndex = startIndex;
        this.endIndex = startIndex + number.length() - 1;
        this.currentLineIndex = currentLineIndex;
        this.number = number;
    }

    List<Gear> findGears(String currentLine, String previousLine, String nextLine) {
        List<Gear> gears = new ArrayList<>();
        findGearInCurrentLineAtStart(currentLine).ifPresent(gears::add);
        findGearInCurrentLineAtEnd(currentLine).ifPresent(gears::add);
        if (previousLine != null) {
            gears.addAll(findGearsInPreviousLine(previousLine));
        }
        if (nextLine != null) {
            gears.addAll(findGearsInNextLine(nextLine));
        }
        return gears;
    }

    private Optional<Gear> findGearInCurrentLineAtStart(String currentLine) {
        if (startIndex > 0 && currentLine.charAt(startIndex - 1) == '*') {
            Gear value = new Gear(currentLineIndex, startIndex - 1);
            return Optional.of(value);
        } else {
            return Optional.empty();
        }
    }

    private Optional<Gear> findGearInCurrentLineAtEnd(String currentLine) {
        if (endIndex < currentLine.length() - 1 && currentLine.charAt(endIndex + 1) == '*') {
            Gear value = new Gear(currentLineIndex, endIndex + 1);
            return Optional.of(value);
        } else {
            return Optional.empty();
        }
    }

    private List<Gear> findGearsInPreviousLine(String previousLine) {
        return findGearsInAdjacentLine(currentLineIndex - 1, previousLine);
    }

    private List<Gear> findGearsInNextLine(String nextLine) {
        return findGearsInAdjacentLine(currentLineIndex + 1, nextLine);
    }

    private List<Gear> findGearsInAdjacentLine(int lineIndex, String line) {
        List<Gear> gears = new ArrayList<>();
        for (int i = startIndex - 1; i <= endIndex + 1; i++) {
            if (i >= 0 && i < line.length() && line.charAt(i) == '*') {
                Gear gear = new Gear(lineIndex, i);
                gears.add(gear);
            }
        }
        return gears;
    }
}
