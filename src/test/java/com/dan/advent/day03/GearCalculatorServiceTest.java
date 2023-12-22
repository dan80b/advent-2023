package com.dan.advent.day03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GearCalculatorServiceTest {

    private final GearService service = new GearService(new GearCalculator());

    @Test
    void sumTotalGear() {
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
        assertEquals(467835, service.sumTotalGear(lines));
    }
}
