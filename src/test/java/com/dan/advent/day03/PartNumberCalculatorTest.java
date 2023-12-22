package com.dan.advent.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartNumberCalculatorTest {

    private final PartNumberCalculator partNumberCalculator = new PartNumberCalculator();

    @Test
    void calculateFirstLine() {
        String currentLine = "12.......*..";
        String nextLine =    "+.........34";
        assertEquals(12, partNumberCalculator.sumPartNumbers(currentLine, null, nextLine));
    }

    @Test
    void calculateMidLine() {
        String previousLine = "..*....60...";
        String currentLine =  "78..........";
        String nextLine =     ".......23...";
        assertEquals(78, partNumberCalculator.sumPartNumbers(currentLine, previousLine, nextLine));
    }

    @Test
    void calculateLastLine() {
        String previousLine = ".*.........*";
        String currentLine =  "1.1.......56";
        assertEquals(58, partNumberCalculator.sumPartNumbers(currentLine, previousLine, null));
    }

    @Test
    void calculateNoPartNumber() {
        String previousLine = "..78........";
        String currentLine =  "..*....60...";
        String nextLine =     "78..........";
        assertEquals(0, partNumberCalculator.sumPartNumbers(currentLine, previousLine, nextLine));
    }

    @Test
    void calculateNegativeNumber() {
        String previousLine = "+.........34";
        String currentLine =  ".......-12..";
        String nextLine =     "..78........";
        assertEquals(12, partNumberCalculator.sumPartNumbers(currentLine, previousLine, nextLine));
    }
}
