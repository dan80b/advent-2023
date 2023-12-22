package com.dan.advent.day03;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class GearService {

    private final GearCalculator gearCalculator;

    int sumTotalGear(List<String> lines) {
        Set<Gear> gears = new HashSet<>();
        for (int i = 0; i < lines.size(); i++) {
            gears = findGears(lines, gears, i);
        }
        return sumGears(gears);
    }

    private Set<Gear> findGears(List<String> lines, Set<Gear> gears, int i) {
        int lastIndex = lines.size() - 1;
        if (i == 0) {
            gears = gearCalculator.findGears(0, lines.get(0), null, lines.get(1), gears);
        } else if (i == lastIndex) {
            gears = gearCalculator.findGears(lastIndex, lines.get(lastIndex), lines.get(lastIndex - 1), null, gears);
        } else {
            gears = gearCalculator.findGears(i, lines.get(i), lines.get(i - 1), lines.get(i + 1), gears);
        }
        return gears;
    }

    private Integer sumGears(Set<Gear> gears) {
        return gears.stream()
                .map(Gear::value)
                .reduce(0, Integer::sum);
    }
}
