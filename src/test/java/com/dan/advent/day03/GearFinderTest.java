package com.dan.advent.day03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GearFinderTest {

    @Test
    void findGearsFirstLine() {
        String currentLine = "12.......*..";
        String nextLine =    "+.........34";
        GearFinder finder = new GearFinder(1, 0, "12");
        List<Gear> gears = finder.findGears(currentLine, null, nextLine);
        assertEquals(0, gears.size());
    }

    @Test
    void findGearsMidLine() {
        String previousLine = "..*....60...";
        String currentLine =  "78..........";
        String nextLine =     ".......23...";
        GearFinder finder = new GearFinder(1, 0, "78");
        List<Gear> gears = finder.findGears(currentLine, previousLine, nextLine);
        assertEquals(1, gears.size());
    }

    @Test
    void findGearsLastLine() {
        String previousLine = ".*.........*";
        String currentLine =  "1.1.......56";
        GearFinder finder = new GearFinder(1, 0, "1");
        List<Gear> gears = finder.findGears(currentLine, previousLine, null);
        assertEquals(1, gears.size());
    }
}
