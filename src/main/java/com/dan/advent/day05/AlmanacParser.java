package com.dan.advent.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlmanacParser {

    private boolean isSeedToSoil = false;
    private boolean isSoilToFertilizer = false;
    private boolean isFertilizerToWater = false;
    private boolean isWaterToLight = false;
    private boolean isLightToTemperature = false;
    private boolean isTemperatureToHumidity = false;
    private boolean isHumidityToLocation = false;

    private final List<AlmanacLine> seedToSoilLines = new ArrayList<>();
    private final List<AlmanacLine> soilToFertilizerLines = new ArrayList<>();
    private final List<AlmanacLine> fertilizerToWaterLines = new ArrayList<>();
    private final List<AlmanacLine> waterToLightLines = new ArrayList<>();
    private final List<AlmanacLine> lightToTemperatureLines = new ArrayList<>();
    private final List<AlmanacLine> temperatureToHumidityLines = new ArrayList<>();
    private final List<AlmanacLine> humidityToLocationLines = new ArrayList<>();

    Almanac parse(List<String> lines) {

        List<Long> seeds = null;

        for (String line : lines) {
            if (line.startsWith("seeds")) {
                seeds = parseSeeds(line);
            } else if (line.startsWith("seed-to-soil map")) {
                isSeedToSoil = true;
            } else if (line.startsWith("soil-to-fertilizer map")) {
                isSoilToFertilizer = true;
            } else if (line.startsWith("fertilizer-to-water map")) {
                isFertilizerToWater = true;
            } else if (line.startsWith("water-to-light map")) {
                isWaterToLight = true;
            } else if (line.startsWith("light-to-temperature map")) {
                isLightToTemperature = true;
            } else if (line.startsWith("temperature-to-humidity map")) {
                isTemperatureToHumidity = true;
            } else if (line.startsWith("humidity-to-location map")) {
                isHumidityToLocation = true;
            } else if (isSeedToSoil && !line.isEmpty()) {
                seedToSoilLines.add(parseAlmanacLine(line));
            } else if(isSoilToFertilizer && !line.isEmpty()) {
                soilToFertilizerLines.add(parseAlmanacLine(line));
            } else if (isFertilizerToWater && !line.isEmpty()) {
                fertilizerToWaterLines.add(parseAlmanacLine(line));
            } else if (isWaterToLight && !line.isEmpty()) {
                waterToLightLines.add(parseAlmanacLine(line));
            } else if (isLightToTemperature && !line.isEmpty()) {
                lightToTemperatureLines.add(parseAlmanacLine(line));
            } else if (isTemperatureToHumidity && !line.isEmpty()) {
                temperatureToHumidityLines.add(parseAlmanacLine(line));
            } else if (isHumidityToLocation && !line.isEmpty()) {
                humidityToLocationLines.add(parseAlmanacLine(line));
            } else if (line.isEmpty()) {
                resetFlags();
            }
        }

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

    private List<Long> parseSeeds(String line) {
        String seedsString = line.split(":")[1].trim();
        return Arrays.stream(seedsString.split(" "))
                .map(Long::parseLong)
                .toList();
    }

    private AlmanacLine parseAlmanacLine(String line) {
        String[] numbers = line.split(" ");
        return new AlmanacLine(Long.parseLong(numbers[0]), Long.parseLong(numbers[1]), Long.parseLong(numbers[2]));
    }

    private void resetFlags() {
        isSeedToSoil = false;
        isSoilToFertilizer = false;
        isFertilizerToWater = false;
        isWaterToLight = false;
        isLightToTemperature = false;
        isTemperatureToHumidity = false;
        isHumidityToLocation = false;
    }
}
