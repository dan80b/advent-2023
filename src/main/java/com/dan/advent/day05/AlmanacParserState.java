package com.dan.advent.day05;

public interface AlmanacParserState {

    void next(AlmanacParser parser, String line);

    void parseLine(AlmanacParser parser, String line);
}
