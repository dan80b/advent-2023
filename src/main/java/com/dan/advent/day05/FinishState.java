package com.dan.advent.day05;

public class FinishState implements AlmanacParserState {

    @Override
    public void next(AlmanacParser parser, String line) {
    }

    @Override
    public void parseLine(AlmanacParser parser, String line) {
        System.out.println("Finish parsing");
    }
}
