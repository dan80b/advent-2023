package com.dan.advent.day03;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GearCalculatorTest {

    private final GearCalculator gearCalculator = new GearCalculator();

    @Test
    void findGearEmptyThenAddHalf() {

        String previousLine = "12.......*..";
        String currentLine =  "+.........34";
        String nextLine =     ".......-12..";

        Set<Gear> gears = gearCalculator.findGears(1, currentLine, previousLine, nextLine, new HashSet<>());
        assertEquals(1, gears.size());

        Gear gear = gears.iterator().next();
        assertEquals(0, gear.getX());
        assertEquals(9, gear.getY());
        assertEquals(34, gear.getLeft());
    }

    @Test
    void findGearHalfThenComplete() {

        String previousLine = "..*....60...";
        String currentLine =  "78..........";
        String nextLine =     "........23...";

        Gear gear = new Gear(4, 2);
        gear.setLeft(78);
        Set<Gear> initGears = new HashSet<>();
        initGears.add(gear);

        Set<Gear> gears = gearCalculator.findGears(5, currentLine, previousLine, nextLine, initGears);
        assertEquals(1, gears.size());

        Gear completedGear = gears.iterator().next();
        assertEquals(4, completedGear.getX());
        assertEquals(2, completedGear.getY());
        assertEquals(78, completedGear.getLeft());
        assertEquals(78, completedGear.getRight());
    }
}
