package com.dan.advent.day05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AlmanacLineState implements AlmanacParserState {

    @Getter
    private final List<AlmanacLine> lines;

    @Override
    public void next(AlmanacParser parser, String line) {
        if (line.isEmpty()) {
            parser.setState(new BreakState());
        }
    }

    @Override
    public void parseLine(AlmanacParser parser, String line) {
        getLines().add(parseAlmanacLine(line));
    }

    private AlmanacLine parseAlmanacLine(String line) {
        String[] numbers = line.split(" ");
        return new AlmanacLine(Long.parseLong(numbers[0]), Long.parseLong(numbers[1]), Long.parseLong(numbers[2]));
    }
}
