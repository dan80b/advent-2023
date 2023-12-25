package com.dan.advent.day05;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Almanac {

    private final List<Long> seeds;

    private final AlmanacMap seedToSoilMap;
    private final AlmanacMap soilToFertilizerMap;
    private final AlmanacMap fertilizerToWaterMap;
    private final AlmanacMap waterToLightMap;
    private final AlmanacMap lightToTemperatureMap;
    private final AlmanacMap temperatureToHumidityMap;
    private final AlmanacMap humidityToLocationMap;

    long soil(long seed) {
        return seedToSoilMap.destination(seed);
    }

    long fertilizer(long soil) {
        return soilToFertilizerMap.destination(soil);
    }

    long water(long fertilizer) {
        return fertilizerToWaterMap.destination(fertilizer);
    }

    long light(long water) {
        return waterToLightMap.destination(water);
    }

    long temperature(long light) {
        return lightToTemperatureMap.destination(light);
    }

    long humidity(long temperature) {
        return temperatureToHumidityMap.destination(temperature);
    }

    long location(long humidity) {
        return humidityToLocationMap.destination(humidity);
    }

    long toLocation(long seed) {
        return location(humidity(temperature(light(water(fertilizer(soil(seed)))))));
    }

    long lowestLocation() {
        return seeds.stream()
                .map(this::toLocation)
                .mapToLong(location -> location)
                .min()
                .orElse(0);
    }

}
