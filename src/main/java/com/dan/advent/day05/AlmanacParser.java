package com.dan.advent.day05;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class AlmanacParser {

    @Getter
    @Setter
    private AlmanacParserState state = new InitState();

    @Setter
    private List<Long> seeds;

    @Getter
    private final List<AlmanacLine> seedToSoilLines = new ArrayList<>();

    @Getter
    private final List<AlmanacLine> soilToFertilizerLines = new ArrayList<>();

    @Getter
    private final List<AlmanacLine> fertilizerToWaterLines = new ArrayList<>();

    @Getter
    private final List<AlmanacLine> waterToLightLines = new ArrayList<>();

    @Getter
    private final List<AlmanacLine> lightToTemperatureLines = new ArrayList<>();

    @Getter
    private final List<AlmanacLine> temperatureToHumidityLines = new ArrayList<>();

    @Getter
    private final List<AlmanacLine> humidityToLocationLines = new ArrayList<>();

    Almanac parse(List<String> lines) {
        processLines(lines);
        return buildAlmanac();
    }

    private void processLines(List<String> lines) {
        for (String line : lines) {
            state.next(this, line);
            state.parseLine(this, line);
        }
    }

    private Almanac buildAlmanac() {
        return new Almanac(
                seeds,
                List.of(
                        new AlmanacMap(seedToSoilLines),
                        new AlmanacMap(soilToFertilizerLines),
                        new AlmanacMap(fertilizerToWaterLines),
                        new AlmanacMap(waterToLightLines),
                        new AlmanacMap(lightToTemperatureLines),
                        new AlmanacMap(temperatureToHumidityLines),
                        new AlmanacMap(humidityToLocationLines))
        );
    }
}
