package com.dan.advent.day05;

import java.util.Arrays;
import java.util.List;

public class SeedsState implements AlmanacParserState {

    @Override
    public void next(AlmanacParser parser, String line) {
        if (line.isEmpty()) {
            parser.setState(new BreakState());
        }
    }

    @Override
    public void parseLine(AlmanacParser parser, String line) {
        parser.setSeeds(parseSeeds(line));
    }

    private List<Long> parseSeeds(String line) {
        String seedsString = line.split(":")[1].trim();
        return Arrays.stream(seedsString.split(" "))
                .map(Long::parseLong)
                .toList();
    }
}
