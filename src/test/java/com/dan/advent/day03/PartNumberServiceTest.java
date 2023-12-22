package com.dan.advent.day03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartNumberServiceTest {

    private final PartNumberService service = new PartNumberService(new PartNumberCalculator());

    @Test
    void sumAllTotalParts() {
        String input = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..
                """;
        List<String> lines = Arrays.asList(input.split("\n"));
        assertEquals(4361, service.sumAllTotalParts(lines));
    }

    @Test
    void sumAllTotalParts2() {
        String input = """
                12.......*..
                +.........34
                .......-12..
                ..78........
                ..*....60...
                78..........
                .......23...
                ....90*12...
                ............
                2.2......12.
                .*.........*
                1.1.......56
                """;
        List<String> lines = Arrays.asList(input.split("\n"));
        assertEquals(413, service.sumAllTotalParts(lines));
    }
}
