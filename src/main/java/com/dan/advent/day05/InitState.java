package com.dan.advent.day05;

public class InitState implements AlmanacParserState {

    @Override
    public void next(AlmanacParser parser, String line) {
        if (line.startsWith("seeds")) {
            parser.setState(new SeedsState());
        } else {
            System.out.println("Seeds not present in first line");
            parser.setState(new FinishState());
        }
    }

    @Override
    public void parseLine(AlmanacParser parser, String line) {
    }
}
