package com.dan.advent.day03;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GearCalculator {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");

    Set<Gear> findGears(int lineIndex, String line, String previousLine, String nextLine, Set<Gear> allGears) {
        Matcher matcher = INTEGER_PATTERN.matcher(line);
        while (matcher.find()) {
            GearFinder gearFinder = new GearFinder(lineIndex, matcher.start(), matcher.group());
            List<Gear> gears = gearFinder.findGears(line, previousLine, nextLine);
            mergeGears(gears, allGears, gearFinder);
        }

        return allGears;
    }

    void mergeGears(List<Gear> gears, Set<Gear> allGears, GearFinder gearFinder) {
        for (Gear gear : gears) {
            Optional<Gear> foundGear = gear.getItselfFromSet(allGears);
            if (foundGear.isPresent()) {
                foundGear.get().setRight(Integer.parseInt(gearFinder.getNumber()));
            } else {
                gear.setLeft(Integer.parseInt(gearFinder.getNumber()));
                allGears.add(gear);
            }
        }
    }
}
