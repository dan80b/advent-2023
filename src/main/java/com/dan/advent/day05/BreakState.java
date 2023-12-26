package com.dan.advent.day05;

import java.util.ArrayList;
import java.util.List;

public class BreakState implements AlmanacParserState {

    @Override
    public void next(AlmanacParser parser, String line) {
        List<AlmanacLine> almanacLines = getAlmanacLines(parser, line);
        parser.setState(new HeaderState(almanacLines));
    }

    private List<AlmanacLine> getAlmanacLines(AlmanacParser parser, String line) {
        List<AlmanacLine> almanacLines = new ArrayList<>();
        if (line.startsWith("seed-to-soil map")) {
            almanacLines = parser.getSeedToSoilLines();
        } else if (line.startsWith("soil-to-fertilizer map")) {
            almanacLines = parser.getSoilToFertilizerLines();
        } else if (line.startsWith("fertilizer-to-water map")) {
            almanacLines = parser.getFertilizerToWaterLines();
        } else if (line.startsWith("water-to-light map")) {
            almanacLines = parser.getWaterToLightLines();
        } else if (line.startsWith("light-to-temperature map")) {
            almanacLines = parser.getLightToTemperatureLines();
        } else if (line.startsWith("temperature-to-humidity map")) {
            almanacLines = parser.getTemperatureToHumidityLines();
        } else if (line.startsWith("humidity-to-location map")) {
            almanacLines = parser.getHumidityToLocationLines();
        }
        return almanacLines;
    }

    @Override
    public void parseLine(AlmanacParser parser, String line) {
    }
}
