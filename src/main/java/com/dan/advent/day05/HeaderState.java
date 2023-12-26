package com.dan.advent.day05;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class HeaderState implements AlmanacParserState {

    private final List<AlmanacLine> almanacLines;

    @Override
    public void next(AlmanacParser parser, String line) {
        parser.setState(new AlmanacLineState(almanacLines));
    }

    @Override
    public void parseLine(AlmanacParser parser, String line) {
    }
}
